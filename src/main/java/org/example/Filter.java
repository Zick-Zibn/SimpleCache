package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class Filter {
    public static void main(String[] args) {

        Predicate<String> predicate = x -> x.length() > 4;

        List<String> src = List.of("qwert", "venrm", "sff", "ssss", "gbvdavAV", "ryrehewe");
        List<String> dest = new ArrayList<>();
        copyIf(src, dest, predicate);
        System.out.println(dest);

    }
    public static <S> void copyIf(List<? extends S> src, List<? super S> dest, Predicate<S> predicate) {

        for (S value : src) {
            if (predicate.test((S) value)) {
                dest.add(value);
            }
        }
    }
}