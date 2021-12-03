package com.ricemarch.accesslambda.customizedcollectors;

import com.ricemarch.accesslambda.dto.Person;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author tanwentao
 * @since 2021/12/3
 */
@Slf4j
public class ExampleFor {

    public static void main(String[] args) {

        List<Person> personList = Person.initRandomList();
        //使用for循环
        method01(personList);

        // forEach 和 StringBuilder
        method02(personList);

        //reduce 和 StringCombiner
        method03(personList);

    }

    private static void method03(List<Person> personList) {
        StringCombiner reduce = personList.stream().map(Person::getName).reduce(new StringCombiner(",", "[", ","), StringCombiner::add, StringCombiner::merge);
        String s = reduce.toString();
        System.out.println(s);
    }


    private static void method02(List<Person> personList) {
        StringBuilder builder = new StringBuilder("[");
        personList.stream().map(Person::getName).forEach(name -> {
            if (builder.length() > 1) {
                builder.append(",");
            }
            builder.append(name);

        });
        builder.append("]");
        String result = builder.toString();
        System.out.println(result);
    }

    private static void method01(List<Person> personList) {
        StringBuilder builder = new StringBuilder("[");

        for (Person person : personList) {
            if (builder.length() > 1) {
                builder.append(",");
            }
            String name = person.getName();
            builder.append(name);
        }
        builder.append("]");
        String result = builder.toString();
        System.out.println(result);
    }
}
