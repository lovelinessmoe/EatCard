package com.EatCard.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DetailBean {

    /*
    CREATE TABLE `Card_detail` (
  `D_id` int NOT NULL AUTO_INCREMENT,
  `C_id` int NOT NULL,
  `change_money` int NOT NULL,
  `Date` date NOT NULL,
  PRIMARY KEY (`D_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
     */

    private int D_id, C_id;
    private Date date;
    private double change_money;
    private String date_str;
    private String C_name;


    public String getC_name() {
        return C_name;
    }

    public void setC_name(String c_name) {
        C_name = c_name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
        if(date!=null){
            SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd");
            date_str = simp.format(this.date);
        }
    }

    public String getDate_str() {
        return date_str;
    }

    public void setDate_str(String date_str) {
        this.date_str = date_str;
    }

    public int getD_id() {
        return D_id;
    }

    public void setD_id(int d_id) {
        D_id = d_id;
    }

    public int getC_id() {
        return C_id;
    }

    public void setC_id(int c_id) {
        C_id = c_id;
    }

    public double getChange_money() {
        return change_money;
    }

    public void setChange_money(double change_money) {
        this.change_money = change_money;
    }
}
