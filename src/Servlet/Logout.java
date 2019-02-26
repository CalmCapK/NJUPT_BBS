package Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class Logout
 * 登出
 * 清除session并redirect到homepage.jsp
 * 管理员redirect到login.jsp
 */
public class Logout extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //response.getWriter().append("Served at: ").append(request.getContextPath());
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //response.getWriter().append("Served at: ").append(request.getContextPath());
        HttpSession session = request.getSession();
        String identity = (String) session.getAttribute("identity");
        if (identity.equals("user")) {
            session.invalidate();
            response.sendRedirect("index.jsp");
        } else if (identity.equals("admin")) {
            session.invalidate();
            response.sendRedirect("login.jsp");
        }


    }

}
