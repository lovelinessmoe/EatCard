package com.EatCard.service;

import com.EatCard.bean.CardBean;
import com.EatCard.dao.CardDao;

import java.util.Scanner;

public class CardService {

    private CardDao cardDao = new CardDao();
    private DetailService detailService = new DetailService();
    private Scanner sc = new Scanner(System.in);


    public CardBean login(int c_id) {
        CardBean login = cardDao.login(c_id);

        return login;

    }

    public double query(CardBean loginbean) {
        return cardDao.query(loginbean.getC_id());
    }

    //zhangzilongstart
    public void logout() {
        System.out.println("请输入你要注销的卡ID");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        double money = cardDao.query(id);
        System.out.println("剩余" + money + "元");
        if (money > 0) {
            System.out.println("请收钱");
        }
        int logout = cardDao.logout(id);
        if (logout > 0) {
            System.out.println(id + "号注销成功");
        } else {
            System.out.println("该卡不存在");
        }
    }
    //zhangzilongend

    //huxiaomingstart
    public void add(CardBean loginbean) {
        System.out.println("充值大酬宾");
        System.out.println("充值100元以上赠送10元");
        System.out.println("充值200元以上赠送30元");
        System.out.println("请输入充值的金额：");
        Scanner sc = new Scanner(System.in);
        double jine = sc.nextDouble();

        if (jine >= 200) {
            jine = jine + 30;
            System.out.println("充值" + jine + "元");
        } else if (jine >= 100) {
            jine = jine + 10;
            System.out.println("充值" + jine + "元");
        }

        if (cardDao.add(jine, loginbean) > 0) {
            System.out.println("充值成功");
            detailService.update(loginbean, jine);
        } else {
            System.out.println("充值失败");
        }
    }

    public void reduce(CardBean loginbean) {
        System.out.println("您要消费的金额是");
        Scanner sr = new Scanner(System.in);
        double money = sr.nextDouble();

        if (cardDao.query(loginbean.getC_id()) >= money) {
            if (cardDao.reduce(money, loginbean) > 0) {
                detailService.update(loginbean, -money);
                System.out.println("用餐愉快");
            }
        } else {
            System.out.println("您的金额已不足，请充值！！！");
        }
    }
    //huxiaomingend

    //zhujunjiestart
    public void lost() {
        System.out.println("请输入你要挂失的卡ID");
        int id = sc.nextInt();
        int rs = cardDao.lost(id);
        if (rs > 0) {
            System.out.println("已挂失");
        } else {
            System.out.println("该卡不存在");
        }
    }
    //zhujunjieend

    //jinhangstart
    public void createcard() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生姓名：");
        String inname = sc.next();
        System.out.println("请输入您要存的金额：");
        double inmoney = sc.nextDouble();
        int rs = cardDao.createcard(inname, inmoney);
        if (rs > 0) {
            System.out.println("开户成功！");
        } else {
            System.out.println("不好意思，开户失败");
        }
    }

    //jinhangend
    public int checkpwd(String pwd, CardBean loginbean) {
        return cardDao.checkpwd(pwd, loginbean.getC_id());

    }
}
