package com.ricemarch.accesslambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortTest {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(List.of(1, 32, 3, 424, 5, 11));
        List<Integer> collect = set.stream().sorted().collect(Collectors.toList());
//        for (Integer integer : collect) {
//            System.out.println(integer);
//        }
        Optional<Integer> collect1 = set.stream().collect(Collectors.maxBy(Comparator.comparing(x -> x)));
        System.out.println(collect1.get());
    }
}
