package me.whiteship.chapter01.item01;

import java.util.EnumSet;
import java.util.Set;

public class Product {

    public static void main(String[] args) {
        // 객체생성에 자유롭다
        Order order = new Order();

        /**
         * 새로운 인스턴스를 생성을 못한다. 가져오기만 한다.
         * 객체 생성을 통제할 수 있다
         */
        Settings settings1 = Settings.newInstance();
        Settings settings2 = Settings.newInstance();

        System.out.println(settings1);
        System.out.println(settings2);
    }
}
