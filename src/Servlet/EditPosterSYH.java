package Servlet;

import DAO.BoardDAO;
import DAO.PosterDAO;
import entity.Board;
import entity.Poster;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class EditPosterSYH extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public EditPosterSYH() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        int posterid = Integer.parseInt(request.getParameter("id"));
        System.out.println("poster:" + request.getParameter("id"));
        PosterDAO posterDAO = PosterDAO.getInstance();
        Poster poster = posterDAO.getByPosterID(posterid);

        request.setAttribute("poster", poster);

        BoardDAO boardDAO = BoardDAO.getInstance();
        List<Board> boards = boardDAO.getAll();
        request.setAttribute("boards", boards);

        RequestDispatcher view = request.getRequestDispatcher("editPosterSYH.jsp");
        view.forward(request, response);
    }

}
