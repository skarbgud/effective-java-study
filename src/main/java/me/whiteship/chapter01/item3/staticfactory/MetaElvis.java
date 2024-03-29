package me.whiteship.chapter01.item3.staticfactory;

import java.util.Objects;

// 코드 3-2 제네릭 싱글톤 팩토리 (24쪽)
public class MetaElvis<T> {

    private static final MetaElvis<Object> INSTANCE = new MetaElvis<>();

    private MetaElvis() { }

    // 타입을 변환해서 반환해 준다.
    @SuppressWarnings("unchecked")
    public static <E> MetaElvis<E> getInstance() {
        return (MetaElvis<E>) INSTANCE;
    }

    public void say(T t) {
        System.out.println(t);
    }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    public static void main(String[] args) {
        MetaElvis<String> elvis1 = MetaElvis.getInstance();  //인스턴스는 동일하지만 제네릭 타입은 다르다.
        MetaElvis<Integer> elvis2 = MetaElvis.getInstance();
        System.out.println(Objects.equals(elvis1, elvis2));  //true
//        System.out.println(elvis1 == elvis2);  // ==은 타입이 달라서 불가능

        System.out.println(elvis1);
        System.out.println(elvis2);
        elvis1.say("hello");
        elvis2.say(100);
    }

}