package com.EatCard.dao;

import com.EatCard.bean.CardBean;
import com.EatCard.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CardDao {

    public CardBean login(int c_id) {
        Connection conn = JDBCUtil.getConnection();
        String sql = "SELECT * FROM Card_info WHERE Card_info.C_id = ?";
        CardBean loginbean = new CardBean();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, c_id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                loginbean.setC_id(rs.getInt("C_id"));
                loginbean.setC_money(rs.getDouble("C_money"));
                loginbean.setC_name(rs.getString("C_name"));
                loginbean.setC_state(rs.getByte("C_state"));
                loginbean.setAdmin(rs.getByte("Admin"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeJDBC(conn, pstm, rs);
        }
        return loginbean;
    }

    public double query(int id) {
        Connection conn = JDBCUtil.getConnection();
        String sql = "select * from Card_info where C_id = ?";
        PreparedStatement pstm = null;
        double c_money = 0;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                c_money = rs.getDouble("C_money");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeJDBC(conn, pstm, null);
        }
        return c_money;
    }

    public int logout(int id) {
        Connection conn = JDBCUtil.getConnection();
        String sql = "DELETE FROM Card_info WHERE C_id = ?";
        PreparedStatement pstm = null;
        int rs = 0;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeJDBC(conn, pstm, null);
        }
        return rs;
    }

    //huxiaomingstart
    public int add(Double jine, CardBean loginbean) {
        Connection conn = JDBCUtil.getConnection();
        String sql = "update Card_info set C_money = C_money+? WHERE Card_info.C_id = ?";
        PreparedStatement pstm = null;
        int i = 0;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setDouble(1, jine);
            pstm.setInt(2, loginbean.getC_id());
            i = pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeJDBC(conn, pstm, null);
        }
        return i;
    }

    public int reduce(Double yve, CardBean loginbean) {
        Connection conn = JDBCUtil.getConnection();
        String sql = "update Card_info set C_money = C_money - ? WHERE Card_info.C_id = ?";
        PreparedStatement pstm = null;
        int rs = 0;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setDouble(1, yve);
            pstm.setInt(2, loginbean.getC_id());
            rs = pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeJDBC(conn, pstm, null);
        }
        return rs;
    }
    //huxiaomingend

    //zhujunjiestart
    public int lost(int id) {
        Connection conn = JDBCUtil.getConnection();
        String sql = "update card_info set C_state = 0 where C_id = ?";
        int rs = 0;
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeJDBC(conn, pstm, null);
        }
        return rs;
    }
    //zhujunjieend


    //jinhangstart
    public int createcard(String inname, double inmoney) {
        Connection conn = JDBCUtil.getConnection();
        String sql = "insert into card_info(C_name,C_money) values(?,?)";
        PreparedStatement pstm = null;
        int rs = 0;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, inname);
            pstm.setDouble(2, inmoney);

            rs = pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeJDBC(conn, pstm, null);
        }
        return rs;

    }

    //jinhangend
    public int checkpwd(String pwd, int c_id) {
        Connection conn = JDBCUtil.getConnection();
        String sql = "SELECT Card_info.Admin_pwd FROM Card_info WHERE Card_info.C_id = ?";
        ResultSet rs = null;
        PreparedStatement pstm = null;
        int flag = 0;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, c_id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                if (pwd.equals(rs.getString("Admin_pwd"))) {
                    flag = 1;
                } else {
                    flag = 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeJDBC(conn, pstm, null);
        }
        return flag;
    }
}

