package com.foo.test.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author jiangwang
 * Created on 2018-12-14
 */
public class LambdaDemo {
    Converter<String ,Integer> converter = Integer::valueOf;

    public static void main(String[] args) {
        List<Person> guiltyPersons = Arrays.asList(
                new Person("jiang","wang",20),
                new Person("zhang","san",18),
                new Person("li","si",33)
        );

        guiltyPersons.stream().filter(p -> p.getFirstName().startsWith("j")).
                forEach(System.out :: println);

        checkAndExecute(guiltyPersons,p -> p.getFirstName().startsWith("j"),
                p -> System.out.println(p.getFirstName()));
    }

    public static void checkAndExecute(List<Person> guiltyPersons,
                                       Predicate<Person> predicate,
                                       Consumer<Person> consumer){

/*        for (Person guiltyPerson : guiltyPersons) {
            if (predicate.test(guiltyPerson)){
                consumer.accept(guiltyPerson);
            }
        }*/

        guiltyPersons.forEach(person -> {
            if (predicate.test(person)) consumer.accept(person);
        });
    }
}
