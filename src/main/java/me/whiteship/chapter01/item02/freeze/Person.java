package me.whiteship.chapter01.item02.freeze;

import java.util.ArrayList;
import java.util.List;

public final class Person {

    private final String name;

    private final int birthYear;

    private final List<String> kids;

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.kids = new ArrayList<>();
    }

//    public void setName(String name) {
//        checkIfObjectIsFrozen();
//        this.name = name;
//    }

    // 어느시점에 freezing이 될지 예측이 안되서 별로다
    private void checkIfObjectIsFrozen() {
//        if (this.frozen()) {
//            throw new IllegalAccessException();
//        }
    }

//    public void setBirthYear(int birthYear) {
//        this.birthYear = birthYear;
//    }

    public static void main(String[] args) {
        Person person = new Person("gyu", 1995);
//        person.name = "규형";
        person.kids.add("규형");

//        person = new Person("남규형", 1111);
    }
}
