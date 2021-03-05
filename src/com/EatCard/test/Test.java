package com.EatCard.test;

import com.EatCard.bean.CardBean;
import com.EatCard.service.CardService;
import com.EatCard.service.DetailService;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CardService cardService = new CardService();

        CardBean loginbean;
        while (true) {
            System.out.println("请放置你的饭卡");
            int c_id = sc.nextInt();
            loginbean = cardService.login(c_id);

            if (loginbean.getC_id() != c_id) {
                System.out.println("该卡不存在，请换一张");
            } else if (loginbean.getC_state() == 0) {
                System.out.println("该卡已挂失，请联系管理员");

            } else {
                System.out.println("你好" + loginbean.getC_name());
                if (loginbean.getAdmin() == 1) {
                    System.out.println("你是尊敬的管理员");
                    System.out.println("请验证管理员密码");

                    String pwd = sc.next();

                    if (cardService.checkpwd(pwd, loginbean) == 1) {
                        System.out.println("欢迎进入食堂管理系统");
                        AdminSystem(loginbean);
                        break;
                    } else {
                        System.out.println("密码错误");
                    }
                } else {
                    //是学生
                    System.out.println("欢迎进入食堂管理系统");
                    UserSystem(loginbean);
                    break;
                }

            }
        }
    }

    private static void UserSystem(CardBean loginbean) {
        Scanner sc = new Scanner(System.in);
        CardService cardService = new CardService();
        DetailService detailService = new DetailService();


        while (true) {
            System.out.println("请输入你要进行的操作:");
            System.out.println("[a]充值\t[b]查询记录与余额");
            System.out.println("[c]消费\t[其他]退出");

            String index = sc.nextLine();

            switch (index.toLowerCase()) {
                case "a":
                    cardService.add(loginbean);
                    break;
                case "b":
                    System.out.println("当前余额为：" + cardService.query(loginbean));
                    detailService.searchcard(loginbean);
                    break;
                case "c":
                    cardService.reduce(loginbean);
                    break;
                default:
                    return;
            }
        }
    }

    private static void AdminSystem(CardBean loginbean) {
        Scanner sc = new Scanner(System.in);
        CardService cardService = new CardService();
        DetailService detailService = new DetailService();

        while (true) {
            System.out.println("请输入你要进行的操作:");
            System.out.println("[a]新卡开户\t[b]卡挂失");
            System.out.println("[c]卡注销\t[d]查询记录与余额");
            System.out.println("\t[其他]退出");

            String index = sc.nextLine();

            switch (index.toLowerCase()) {
                case "a":
                    cardService.createcard();
                    break;
                case "b":
                    cardService.lost();
                    break;
                case "c":
                    cardService.logout();
                    break;
                case "d":
                    System.out.println("当前余额为：" + cardService.query(loginbean));
                    detailService.searchcard(loginbean);
                    break;
                default:
                    return;
            }
        }
    }
}
