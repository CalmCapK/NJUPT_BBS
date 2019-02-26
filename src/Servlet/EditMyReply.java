package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PosterDAO;
import DAO.ReplyDAO;
import entity.Poster;
import entity.Reply;

public class EditMyReply extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        int replyid = Integer.parseInt(request.getParameter("replyid"));
        String replycontent = request.getParameter("replycontent");
        ReplyDAO rd = ReplyDAO.getInstance();
        Reply r = rd.getByReplyID(replyid);
        Reply reply = new Reply();
        reply.setPosterID(r.getPosterID());
        reply.setUserID(r.getUserID());
        reply.setReplyID(replyid);
        reply.setReplyContent(replycontent);
        reply.setReplyTime(r.getReplyTime());
        rd.updateReply(reply);
        response.sendRedirect("PosterInfo?id="+r.getPosterID());
    }


}
