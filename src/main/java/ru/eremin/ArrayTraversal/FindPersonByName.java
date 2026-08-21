package ru.eremin.ArrayTraversal;

import java.util.List;
import java.util.Optional;

public class FindPersonByName {

    static Optional<Person> findPersonByName(List<Person> persons, String name) {
        return persons.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst();
    }
}

// Реализовать функцию поиска Person по значению name
class Person {
    private final String name;
    private final Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
