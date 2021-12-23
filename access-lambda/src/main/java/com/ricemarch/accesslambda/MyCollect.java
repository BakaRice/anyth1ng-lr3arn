package com.ricemarch.accesslambda;

import java.util.List;
import java.util.stream.Collectors;

public class MyCollect {
    public static void main(String[] args) {

        List<String> strings = List.of("Hi", "I", "AM", "YOUR", "DAD", "!");
        String collect = strings.stream().collect(Collectors.joining(",", "![", "]!"));
        System.out.println(collect);
        //![Hi,I,AM,YOUR,DAD,!]!
    }
}
