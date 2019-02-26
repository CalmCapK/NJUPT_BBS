package Servlet;

import DAO.BoardDAO;
import DAO.PosterDAO;
import DAO.ReplyDAO;
import entity.Board;
import entity.Poster;
import entity.Reply;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class EditReply extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public EditReply() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        int replyid =  Integer.parseInt(request.getParameter("id"));
        ReplyDAO replyDAO = ReplyDAO.getInstance();
        Reply reply = replyDAO.getByReplyID(replyid);
        request.setAttribute("reply", reply);
        RequestDispatcher view = request.getRequestDispatcher("editReply.jsp");
        view.forward(request, response);
    }

}
