package Servlet;

import DAO.PosterDAO;
import DAO.ReplyDAO;
import DAO.UserDAO;
import entity.Poster;
import entity.Reply;
import entity.ReplyList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PosterInfo extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PosterDAO posterDAO = PosterDAO.getInstance();
        ReplyDAO replyDAO = ReplyDAO.getInstance();
        UserDAO ud = UserDAO.getInstance();
        int posterid = Integer.parseInt(request.getParameter("id"));
        Poster poster = posterDAO.getByPosterID(posterid);
        int i = poster.getCounter();
        posterDAO.addCounter(posterid);
        String name = ud.getByUserName(poster.getUserID());
        List<Reply> replyList = new ArrayList<Reply>();
        replyList = replyDAO.getByPosterID(posterid);
        ReplyList rl = new ReplyList();
        rl.setReplyList(replyList);
        request.setAttribute("poster", poster);
        request.setAttribute("replyList", rl);
        request.setAttribute("pname", name);
        request.getRequestDispatcher("poster.jsp").forward(request, response);
    }
}
