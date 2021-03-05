package com.EatCard.service;

import com.EatCard.bean.CardBean;
import com.EatCard.bean.DetailBean;
import com.EatCard.dao.DetailDao;

import java.util.ArrayList;

public class DetailService {


    private DetailDao detailDao = new DetailDao();

    void update(CardBean loginbean, Double jine) {
        detailDao.update(loginbean, jine);
    }


    //jinhangstart
    public void searchcard(CardBean loginbean) {
        ArrayList<DetailBean> list = detailDao.searchcard(loginbean);
        for (DetailBean detailBean : list) {
            System.out.println();
            System.out.print("序号:" + detailBean.getD_id() +
                    "\t\t学生卡ID:" + detailBean.getC_id());
            if (detailBean.getC_name() != null) {
                System.out.print("\t\t学生姓名:" + detailBean.getC_name());
            } else {
                System.out.print("\t\t该卡已注销");
            }
            if (detailBean.getChange_money() < 0) {
                System.out.print("\t\t消费" + (-detailBean.getChange_money()));
            } else {
                System.out.print("\t\t存入" + detailBean.getChange_money());
            }
            System.out.println("\t\t时间" + detailBean.getDate_str());
        }
    }
    //jinhangend
}
