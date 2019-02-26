package Servlet;

import DAO.BoardDAO;
import DAO.PosterDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Homepage extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Homepage() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        BoardDAO boardDAO = BoardDAO.getInstance();
        PosterDAO posterDAO = PosterDAO.getInstance();

    }

}
