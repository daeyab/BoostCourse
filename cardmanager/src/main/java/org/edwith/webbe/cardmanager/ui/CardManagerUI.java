package org.edwith.webbe.cardmanager.ui;

import org.edwith.webbe.cardmanager.dto.BusinessCard;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class CardManagerUI {
    private BufferedReader in;

    private CardManagerUI(){
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    private static CardManagerUI instance = new CardManagerUI();

    public static CardManagerUI getInstance(){
        return instance;
    }

    public void printMainMenu(){
        System.out.println("------------------------");
        System.out.println("1. 명함 입력");
        System.out.println("2. 명함 검색");
        System.out.println("3. 종료");
        System.out.println("------------------------");
        System.out.print("메뉴를 입력하세요 : ");
    }

    public int getMenuNumber(){
        try {
            int menuNumber = Integer.parseInt(in.readLine());
            return menuNumber;
        }catch(Exception ex){
            return -1; // 숫자로 변환 못할 경우 -1을 리턴한다.
        }
    }

    public BusinessCard inputBusinessCard(){
        try {
            System.out.print("이름을 입력하세요 : ");
            String name = in.readLine();
            System.out.print("전화번호를 입력하세요. : ");
            String phone = in.readLine();
            System.out.print("회사 이름을 입력하세요. : ");
            String companyName = in.readLine();
            BusinessCard businessCard = new BusinessCard(name, phone, companyName);
            return businessCard;
        }catch(Exception ex){
            System.out.println("잘못된 값을 입력했습니다. ");
            return null;
        }
    }

    public String getSearchKeyword(){
        try {
            System.out.print("검색할 이름을 입력하세요. (like검색) : ");
            String searchKeyword = in.readLine();
            return searchKeyword;
        }catch(Exception ex){
            System.out.println("잘못된 값을 입력했습니다. ");
            return null;
        }
    }

    public void printBusinessCards(List<BusinessCard> businessCardList){
        for(BusinessCard businessCard: businessCardList){
            System.out.println(businessCard);
            System.out.println("---------------------------------------------------------------");
        }
    }

    public void printExitMessage(){
        System.out.println("프로그램을 종료합니다. :-) ");
    }

    public void printErrorMessage(){
        System.out.println("잘못된 입력입니다.");
    }
}
