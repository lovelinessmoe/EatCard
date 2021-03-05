package com.EatCard.bean;

public class CardBean {

    /*
    CREATE TABLE `Card_info` (
  `C_id` int NOT NULL AUTO_INCREMENT,
  `C_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `C_money` decimal(65,2) NOT NULL,
  `C_state` tinyint NOT NULL DEFAULT '1',
  `Admin` tinyint(1) NOT NULL DEFAULT '0',
  `Admin_pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`C_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
     */

    private int C_id;
    private Double C_money;
    private String C_name;
    private byte Admin, C_state;
    private String Admin_pwd;


    public String getAdmin_pwd() {
        return Admin_pwd;
    }

    public void setAdmin_pwd(String admin_pwd) {
        Admin_pwd = admin_pwd;
    }

    public byte getC_state() {
        return C_state;
    }

    public void setC_state(byte c_state) {
        C_state = c_state;
    }

    public byte getAdmin() {
        return Admin;
    }

    public void setAdmin(byte admin) {
        Admin = admin;
    }

    public int getC_id() {
        return C_id;
    }

    public void setC_id(int c_id) {
        C_id = c_id;
    }


    public Double getC_money() {
        return C_money;
    }

    public void setC_money(Double c_money) {
        C_money = c_money;
    }

    public String getC_name() {
        return C_name;
    }

    public void setC_name(String c_name) {
        C_name = c_name;
    }
}
