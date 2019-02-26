package Servlet;

import DAO.UserDAO;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class DisLock extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DisLock() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        int userid = Integer.parseInt(request.getParameter("userid"));
        UserDAO userDAO = UserDAO.getInstance();
        User user = userDAO.getByUserID(userid);
        userDAO.disLock(user);
        response.sendRedirect("adminhomepage.jsp?dislock=1");
    }

}
