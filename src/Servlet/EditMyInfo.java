package Servlet;

import DAO.UserDAO;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class EditMyInfo extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public EditMyInfo() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userid = (int) session.getAttribute("userid");
        String username = request.getParameter("username");
        String password = request.getParameter("userpassword");

        //通过userid得到user,并修改其中的username,userpassword
        UserDAO ud = UserDAO.getInstance();
        User user = (User) ud.getByUserID(userid);
        user.setUsernName(username);

        if (password.equals("orign")) {
            password = user.getUserPassword();
        }
        user.setUserPassword(password);
        user.setIsLock(user.getIsLock());
        user.setUserID(user.getUserID());
        ud.updateUser(user);
        response.sendRedirect("homepage.jsp");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
