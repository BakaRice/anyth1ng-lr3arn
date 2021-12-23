package com.ricemarch.accesslambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class P {
    public static void main(String[] args) {
//        List<Integer> t = List.of(1, 2, 3, 3, 445, 9);
        List<Integer> t = new ArrayList<>();
        t.add(null);
        //传统式
        Integer sum = null;
        for (Integer curr : t) {
            if (sum == null) {
                sum = 0;
            }
            if (curr != null) {
                sum += curr;
            }
        }
//        System.out.println(sum);
        //函数式的编程
        Optional<Integer> reduce = t.stream().filter(x -> x != null).reduce((acc, b) -> acc + b);
//        System.out.println(reduce.get());

    }
}
