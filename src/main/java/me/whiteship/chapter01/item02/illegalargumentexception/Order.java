package me.whiteship.chapter01.item02.illegalargumentexception;

import java.time.LocalDate;

public class Order {

    public void updateDeliveryDate(LocalDate deliveryDate) throws IllegalArgumentException { // 명시적으로 알려주고 싶을때 선언하기도 함 (보통 checkedException 만 표기함)
        if (deliveryDate == null) {
            throw new NullPointerException("deliveryDate can't be null");
        }
        if (deliveryDate.isBefore(LocalDate.now())) {
            //TODO 과거로 배송 해달라?
            throw new IllegalArgumentException("deliveryDate can't be earlier than " + LocalDate.now());
        }
    }
}
