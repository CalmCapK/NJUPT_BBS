package Servlet;

import DAO.PosterDAO;
import entity.Poster;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class SetTop extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public SetTop() {
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
        Poster poster = posterDAO.getByPosterID(posterid);
        posterDAO.setTop(poster);
        response.sendRedirect("adminhomepage.jsp?settop=1");

    }

}
