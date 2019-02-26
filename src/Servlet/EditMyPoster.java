package Servlet;

import DAO.PosterDAO;
import entity.Poster;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditMyPoster extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        int posterid = Integer.parseInt(request.getParameter("posterid"));
        String postertitle = request.getParameter("postertitle");
        String postercontent = request.getParameter("postercontent");
        PosterDAO pd = PosterDAO.getInstance();
        Poster p = pd.getByPosterID(posterid);

        Poster poster = new Poster();
        poster.setBoardID(p.getBoardID());
        poster.setPosterContent(postercontent);
        poster.setPosterID(posterid);
        poster.setPosterTitle(postertitle);
        poster.setSeqNum(p.getSeqNum());
        pd.updatePoster(poster);

        response.sendRedirect("PosterInfo?id=" + posterid);
    }


}
