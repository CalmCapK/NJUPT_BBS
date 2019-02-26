package Servlet;

import DAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class DeleteUser extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public DeleteUser() {
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
        userDAO.deleteUser(userid);
        response.sendRedirect("adminhomepage.jsp?deleteuser=1");
    }

}
