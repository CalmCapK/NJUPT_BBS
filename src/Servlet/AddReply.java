package Servlet;

import DAO.ReplyDAO;
import entity.Reply;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddReply extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        int posterid = Integer.parseInt(request.getParameter("posterid"));
        int userid = (int) session.getAttribute("userid");
        String replycontent = request.getParameter("replycontent");

        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String replydatetime = s.format(date);

        Reply reply = new Reply();
        reply.setPosterID(posterid);
        reply.setUserID(userid);
        reply.setReplyContent(replycontent);
        reply.setReplyTime(replydatetime);
        ReplyDAO rd = ReplyDAO.getInstance();
        rd.addReply(reply);

        response.sendRedirect("PosterInfo?id=" + posterid);
    }

}
