package me.whiteship.chapter01.item01;

// enum 타입들은 jvm 내에서 단 하나의 인스턴스만 만들어진다.
public enum OrderStatus {

    PREPARING(0), SHIPPED(1), DELIVERING(2), DELIVERED(3);

    private int number;

    OrderStatus(int number) {
        this.number = number;
    }
}
