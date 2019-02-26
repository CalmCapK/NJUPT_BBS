package Tag;

import DAO.PosterDAO;
import DAO.ReplyDAO;
import DAO.UserDAO;
import entity.Poster;
import entity.Reply;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShowPosterTag extends SimpleTagSupport {
    private String key;

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public void doTag() throws JspException, IOException {

        if (this.key == null)
            this.key = "7";
        int bid = Integer.parseInt(this.key);
        PosterDAO pd = PosterDAO.getInstance();
        List<Poster> posters = new ArrayList<Poster>();
        UserDAO ud = UserDAO.getInstance();
        if (bid == 8) {
            int userid = (int) getJspContext().findAttribute("userid");
            posters = pd.getByUserID(userid);
        } else if (bid == 7) {
            posters = pd.getNewTen();
        } else {
            posters = pd.getByBoardID(bid);
        }

        JspWriter out = getJspContext().getOut();

        String outPrint = "";
        outPrint += "<section class=\"container\">\r\n" +
                "	<div class=\"content-wrap\">\r\n" +
                "		<div class=\"content\">";
        for (Poster p : posters) {
            ReplyDAO rd = ReplyDAO.getInstance();
            List<Reply> replys = new ArrayList<Reply>();
            replys = rd.getByPosterID(p.getPosterID());
            String name = ud.getByUserName(p.getUserID());
            outPrint += "<article class=\"excerpt excerpt-1\" style=\"\"> \r\n" +
                    "			<a class=\"focus\" target=\"_blank\"> \r\n" +
                    "				<img class=\"thumb\" src=\"images/nanyou_2.jpeg\" style=\"display: inline;\">\r\n" +
                    "			</a> \r\n" +
                    "			<header>\r\n" +
                    "				<h2>\r\n" +
                    "					<a href=\"PosterInfo?id=" + p.getPosterID() + "\" target=\"_blank\">";
            outPrint += p.getPosterTitle();
            outPrint += "</a>\r\n" +
                    "			</h2>\r\n" +
                    "		</header>\r\n" +
                    "		<p class=\"meta\">\r\n" +
                    "		<a href=\"#list/3/\" rel=\"tag\" >";
            outPrint += name;
            outPrint += "</a><br>\r\n" +
                    "			<time class=\"time\"><i class=\"glyphicon glyphicon-time\"></i>";
            outPrint += p.getPosterTime();
            outPrint += "</time>\r\n" +
                    "			<span class=\"views\"><i class=\"glyphicon glyphicon-eye-open\"></i>";
            outPrint += p.getCounter();
            outPrint += "</span> <a class=\"comment\" href=\"##comment\" title=\"����\"\r\n" +
                    "					target=\"_blank\"><i class=\"glyphicon glyphicon-comment\"></i>";
            outPrint += replys.size();
            outPrint += "</a>\r\n" +
                    "			</p>\r\n" +
                    "			</article>";
        }
        outPrint += "</div>\r\n" +
                "	</div> \r\n" +
                "	</section>";
        out.print(outPrint);
    }
}
