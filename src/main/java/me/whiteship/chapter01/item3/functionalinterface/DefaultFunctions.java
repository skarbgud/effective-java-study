package me.whiteship.chapter01.item3.functionalinterface;

import me.whiteship.chapter01.item3.methodreference.Person;

import java.time.LocalDate;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class DefaultFunctions {

    public static void main(String[] args) {
//        Function<Integer, String> intToString;
//        Supplier<Person> personSupplier;
//        Consumer<Integer> integerConsumer;
//        Predicate<Integer> predicate;

        // Function<Input, output>
//        Function<Integer, String> intToString = (i) -> "hello";
        Function<Integer, String> intToString = Objects::toString;

        // Supplier : 받는것 없고 나오는것만 있는것
        Supplier<Person> personSupplier = Person::new;

        // 기본 생성자가 아닌경우에 생성하고 싶을때 => Function으로 생성
        Function<LocalDate, Person> personFunction = Person::new;

        // 받는건 있지만 리턴이 없는것
        Consumer<Integer> integerConsumer = System.out::println;

        // 인자를 받아서 boolean을 리턴하는것
        Predicate<Person> predicate;
    }
}