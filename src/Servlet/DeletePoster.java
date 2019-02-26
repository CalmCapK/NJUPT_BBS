package Servlet;

import DAO.PosterDAO;
import DAO.ReplyDAO;
import entity.Reply;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class DeletePoster extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public DeletePoster() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        int posterid = Integer.parseInt(request.getParameter("posterid"));
        PosterDAO posterDAO = PosterDAO.getInstance();
        ReplyDAO replyDAO = ReplyDAO.getInstance();
        replyDAO.deleteByPosterID(posterid);
        posterDAO.deletePoster(posterid);
        response.sendRedirect("adminhomepage.jsp?deleteposter=1");
    }

}
