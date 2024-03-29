package me.whiteship.chapter01.methodreference;

import autovalue.shaded.com.google$.common.base.$Function;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Person {

    LocalDate birthday;

    // 스테틱 메소드 레퍼런스
//    public static int compareByAge(Person a, Person b) {
//        return a.birthday.compareTo(b.birthday);
//    }

    // 인스턴스 메소드 레퍼런스
//    public int compareByAge(Person a, Person b) {
//        return a.birthday.compareTo(b.birthday);
//    }

    // 임의 객채의 인스턴스 메소드 레퍼런스
//    public int compareByAge(Person b) {
//        return this.birthday.compareTo(b.birthday);
//    }

    public Person() {

    }

    public Person(LocalDate birthday) {
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        // 생성자 레퍼런스
        List<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.of(1982, 7, 15));
        dates.add(LocalDate.of(1982, 7, 15));
        dates.add(LocalDate.of(1982, 7, 15));
//        Function<LocalDate, Person> aNew = Person::new;
        dates.stream().map(Person::new).collect(Collectors.toList());

        List<Person> people = new ArrayList<>();
        people.add(new Person(LocalDate.of(1982, 7, 15)));
        people.add(new Person(LocalDate.of(2011, 3, 2)));
        people.add(new Person(LocalDate.of(2013, 1, 28)));

//        people.sort(new Comparator<Person>() {
//            @Override
//            public int compare(Person a, Person b) {
//                return a.birthday.compareTo(b.birthday);
//            }
//        });

//        people.sort((p1, p2) -> p1.birthday.compareTo(p2.birthday));
//        people.sort((p1, p2) -> Person.compareByAge(p1, p2)); //람다
//        people.sort(Person::compareByAge); // 스테틱 메소드 레퍼런스

//        Person person = new Person(null);
//        people.sort(person::compareByAge); //인스턴스 메소드 레퍼런스

        //참조는 되지만 호환이 안된다.
//        Comparator<Person> compareByAge = (Comparator<Person>) Person::compareByAge; //임의 객체의 인스턴스 메소드 레퍼런스
//        people.sort(compareByAge);



    }

    public int getAge() {
        return LocalDate.now().getYear() - birthday.getYear();
    }

}