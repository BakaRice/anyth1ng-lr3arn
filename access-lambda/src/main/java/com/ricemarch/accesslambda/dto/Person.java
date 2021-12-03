package com.ricemarch.accesslambda.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author tanwentao
 * @since 2021/12/3
 */

@Data
public class Person {

    private String name;


    public static List<Person> initRandomList() {
        List<Person> list = new ArrayList<>();
        Random random = new Random();
        int i1 = random.nextInt(1000);
        System.out.println(i1);
        for (int i = 0; i < i1; i++) {
            Person person = new Person(createRandomStr1(4));
            list.add(person);
        }
        return list;
    }

    public Person(String name) {
        this.name = name;
    }

    public static String createRandomStr1(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            stringBuffer.append(str.charAt(number));
        }
        return stringBuffer.toString();
    }
}
