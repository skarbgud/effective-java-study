package me.whiteship.chapter01.item01;

import java.util.*;

public class Order {

    private boolean prime;

    private boolean urgent;

    private Product product;

    private OrderStatus orderStatus;

    // 0 - 주문받음
    // 1 - 준비중
    // 2 - 배송 중
    // 3 - 배송완료
//    private int status;
//
//    private final int PREPARING = 0;
//    private final int SHIPPED = 2;

//    public Order(Product product, boolean prime) {
//        this.product = product;
//        this.prime = prime;
//    }
//
//    public Order(boolean urgent, Product product) {
//        this.product = product;
//        this.urgent = urgent;
//    }

    // 정적 팩토리 메소드를 사용
    public static Order primeOrder(Product product) {
        Order order = new Order();
        order.prime = true;
        order.product = product;

        // 허용하지 않는값을 검증할 필요가 있음 ex) orderStatus에 200 값이 들어간다면
//        if (order.status == order.PREPARING) {
//
//        }
        return order;
    }

    public static Order urgentOrder(Product product) {
        Order order = new Order();
        order.urgent = true;
        order.product = product;
        return order;
    }

    public static void main(String[] args) {
        Order order = new Order();
        // enum 비교연산은 equals 보다는 == 을 사용하자
        if (order.orderStatus == OrderStatus.DELIVERED) {
//        if (order.orderStatus.equals(OrderStatus.DELIVERED)) {
            System.out.println("delivered");
        }
//        Arrays.stream(OrderStatus.values()).forEach(System.out::println);
    }
}
