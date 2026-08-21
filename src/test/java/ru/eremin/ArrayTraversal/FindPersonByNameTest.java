package ru.eremin.ArrayTraversal;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindPersonByNameTest {
    @Test
    void shouldFindPersonByName() {
        Person person1 = new Person("Vasya", 18);
        Person person2 = new Person("Petya", 20);
        Person person3 = new Person("Grisha", 22);
        List<Person> persons = List.of(person1, person2, person3);


        Optional<Person> expected = Optional.of(person2);

        Optional<Person> actual = FindPersonByName.findPersonByName(persons, "Petya");

        assertEquals(expected, actual);
    }
}
