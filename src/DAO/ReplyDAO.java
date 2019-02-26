package DAO;

import entity.Reply;
import utils.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReplyDAO {
    public static ReplyDAO getInstance() {
        return new ReplyDAO();
    }

    public List<Reply> getByPosterID(int posterid) {
        List<Reply> replys = new ArrayList<Reply>();
        Reply reply = null;
        try {

            Connection conn = DBHelper.getInstance().getConnection();
            Statement stem = conn.createStatement();

            String sql = "select * from reply where posterid = " + posterid + ";";
            ResultSet rs = stem.executeQuery(sql);
            while (rs.next()) {
                reply = new Reply();
                int replyid = rs.getInt("replyid");
                int userid = rs.getInt("userid");
                String replycontent = rs.getString("replycontent");
                String replytime = rs.getString("replytime");
                reply.setReplyID(replyid);
                reply.setPosterID(posterid);
                reply.setUserID(userid);
                reply.setReplyContent(replycontent);
                reply.setReplyTime(replytime);
                replys.add(reply);
            }
            DBHelper.closeConnection(conn, stem, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return replys;
    }

    public Reply getByReplyID(int replyid) {
        Reply reply = null;
        try {

            Connection conn = DBHelper.getInstance().getConnection();
            Statement stem = conn.createStatement();

            String sql = "select * from reply where replyid = " + replyid + ";";

            ResultSet rs = stem.executeQuery(sql);
            if (rs.next()) {
                reply = new Reply();
                int userid = rs.getInt("userid");
                int posterid = rs.getInt("posterid");
                String replycontent = rs.getString("replycontent");
                String replytime = rs.getString("replytime");
                reply.setPosterID(posterid);
                reply.setUserID(userid);
                reply.setReplyID(replyid);
                reply.setReplyContent(replycontent);
                reply.setReplyTime(replytime);
            }
            DBHelper.closeConnection(conn, stem, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reply;
    }

    public void updateReply(Reply reply) {
        try {
            Connection c = DBHelper.getInstance().getConnection();

            String sql = "update reply set replycontent= ? where replyid = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, reply.getReplyContent());
            ps.setInt(2, reply.getReplyID());
            ps.execute();
            DBHelper.closeConnection(c, ps, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Reply> getByUserID(int userid) {
        List<Reply> replys = new ArrayList<Reply>();
        Reply reply = null;
        try {

            Connection conn = DBHelper.getInstance().getConnection();
            Statement stem = conn.createStatement();

            String sql = "select * from reply where userid = " + userid + ";";
            ResultSet rs = stem.executeQuery(sql);
            while (rs.next()) {
                reply = new Reply();
                int replyid = rs.getInt("replyid");
                int posterid = rs.getInt("posterid");
                String replycontent = rs.getString("replycontent");
                String replytime = rs.getString("replytime");
                reply.setReplyID(replyid);
                reply.setPosterID(posterid);
                reply.setUserID(userid);
                reply.setReplyContent(replycontent);
                reply.setReplyTime(replytime);
                replys.add(reply);
            }
            DBHelper.closeConnection(conn, stem, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return replys;
    }

    public void addReply(Reply reply) {
        try {

            Connection c = DBHelper.getInstance().getConnection();

            String sql = "insert into reply values(null,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, reply.getPosterID());
            ps.setInt(2, reply.getUserID());
            ps.setString(3, reply.getReplyContent());
            ps.setString(4, reply.getReplyTime());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                reply.setReplyID(id);
            }
            DBHelper.closeConnection(c, ps, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteReply(int replyid) {
        try {
            Connection c = DBHelper.getInstance().getConnection();
            Statement s = c.createStatement();
            String sql = "delete from reply where replyid = " + replyid + ";";

            s.execute(sql);

            DBHelper.closeConnection(c, s, null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteByPosterID(int posterid) {
        try {
            Connection c = DBHelper.getInstance().getConnection();
            Statement s = c.createStatement();
            String sql = "delete from reply where posterid = " + posterid + ";";
            s.execute(sql);

            DBHelper.closeConnection(c, s, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
