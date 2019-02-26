package Tag;

import DAO.PosterDAO;
import DAO.UserDAO;
import entity.Reply;
import entity.ReplyList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShowReplyTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {

        PosterDAO pd = PosterDAO.getInstance();
        List<Reply> replys = new ArrayList<Reply>();
        UserDAO ud = UserDAO.getInstance();
        ReplyList rl = new ReplyList();
        rl = (ReplyList) getJspContext().findAttribute("replyList");
        int userid = -1;
        String identity = (String)getJspContext().findAttribute("identity");
        System.out.println(identity);
        if(identity!=null && identity.equals("user")){
            userid = (int)getJspContext().findAttribute("userid");
        }else if(identity!=null && identity.equals("admin")){
            userid = (int)getJspContext().findAttribute("adminid");
        }
        System.out.println(userid);

        replys = rl.getReplyList();

        JspWriter out = getJspContext().getOut();

        String outPrint = "";
        int i = 2;
        outPrint += "<div id=\"postcomments\">\r\n" +
                "				<ol id=\"comment_list\" class=\"commentlist\">";
        for (Reply r : replys) {
            String name = ud.getByUserName(r.getUserID());
            outPrint += "<li class=\"comment-content\"><span class=\"comment-f\">#";
            outPrint += i++;
            outPrint += "</span>\r\n" +
                    "					<div class=\"comment-main\">\r\n" +
                    "							<p>\r\n" +
                    "								<a class=\"address\" href=\"#\" rel=\"nofollow\" target=\"_blank\">";
            outPrint += name;
            outPrint += "</a><span\r\n" +
                    "									class=\"time\">";
            outPrint += r.getReplyTime();
            outPrint += "</span>";
            if (userid == r.getUserID()){
                outPrint += "<a href=\"EditReply?id=";
                outPrint += r.getReplyID();
                outPrint +="\" title=\"修改回复\">修改</a>";
            }
            outPrint += "<br>";
            outPrint += r.getReplyContent();
            outPrint += "</p>\r\n";
            outPrint +="</div></li>";
        }
        outPrint += "</ol>\r\n" +
                "			</div>";
        out.print(outPrint);
    }
}
