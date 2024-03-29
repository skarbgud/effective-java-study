package me.whiteship.chapter01.item3.functionalinterface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UsageOfFunctions {

    public static void main(String[] args) {
        List<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.of(1982, 7, 15));
        dates.add(LocalDate.of(2011, 3, 2));
        dates.add(LocalDate.of(2013, 1, 28));

        Predicate<LocalDate> localDatePredicate = d -> d.isBefore(LocalDate.of(2000, 1, 1));
        Function<LocalDate, Integer> getYear = LocalDate::getYear;

        List<Integer> before2000 = dates.stream()
                .filter(d -> d.isBefore(LocalDate.of(2000, 1, 1))) //Stream<T> filter(Predicate<? super T> predicate);
                .map(LocalDate::getYear)
                .collect(Collectors.toList());
    }
}