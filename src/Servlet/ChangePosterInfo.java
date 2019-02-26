package Servlet;

import DAO.PosterDAO;
import entity.Poster;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ChangePosterInfo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ChangePosterInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        int posterid = Integer.parseInt(request.getParameter("posterid"));
        System.out.println("poster:" + request.getParameter("posterid"));

        PosterDAO posterDAO = PosterDAO.getInstance();
        Poster poster = posterDAO.getByPosterID(posterid);
        poster.setPosterTitle(request.getParameter("postertitle"));
        poster.setPosterContent(request.getParameter("postercontent"));


        System.out.println(request.getParameter("postertitle"));
        System.out.println(request.getParameter("postercontent"));


        int boardid = Integer.parseInt(request.getParameter("boardid"));

        poster.setBoardID(boardid);
        posterDAO.updatePoster(poster);

        response.sendRedirect("adminhomepage.jsp?update=1");

    }

}
