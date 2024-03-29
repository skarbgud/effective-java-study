package me.whiteship.chapter01.item3.functionalinterface;

@FunctionalInterface
public interface MyFunction {

    String valueOf(Integer integer);

    static String hello() {
        return "hello";
    }
}
