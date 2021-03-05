package com.EatCard.dao;

import com.EatCard.bean.CardBean;
import com.EatCard.bean.DetailBean;
import com.EatCard.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class DetailDao {

    public int update(CardBean loginbean, Double jine) {
        java.sql.Date time = new java.sql.Date(new Date().getTime());
        //数据库Date日期

        Connection conn = JDBCUtil.getConnection();
        String sql = "insert into Card_detail (C_id, change_money,Date)values (?,?,?)";
        PreparedStatement pstm = null;
        int rs = 0;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, loginbean.getC_id());
            pstm.setDouble(2, jine);
            pstm.setDate(3, time);
            rs = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeJDBC(conn, pstm, null);
        }
        return rs;
    }

    //jinhangstart
    public ArrayList<DetailBean> searchcard(CardBean loginbean) {
        Connection conn = JDBCUtil.getConnection();
        String sql;
        PreparedStatement pstm ;
        ArrayList<DetailBean> list = new ArrayList<DetailBean>();
        DetailBean db;
        if (loginbean.getAdmin() == 1) {
            sql = "select d.* , i.C_name from card_detail as d LEFT JOIN Card_info as i ON i.C_id=d.C_id ";
        } else {
            sql = "select d.* , i.C_name from card_detail as d LEFT JOIN Card_info as i ON i.C_id=d.C_id  where d.C_id = ?";
        }
        try {
            pstm = conn.prepareStatement(sql);
            if (loginbean.getAdmin() == 0) {
                pstm.setInt(1, loginbean.getC_id());
            }
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int Did = rs.getInt("D_id");
                int Cid = rs.getInt("C_id");
                double changemoney = rs.getDouble("change_money");
                Date time = rs.getDate("Date");

                db = new DetailBean();

                db.setC_name(rs.getString("C_name"));
                db.setC_id(Cid);
                db.setD_id(Did);
                db.setChange_money(changemoney);
                db.setDate(time);
                list.add(db);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    //jinhangend

}
