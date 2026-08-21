package ru.eremin.ArrayTraversal;

import java.util.List;
import java.util.stream.Stream;

/**
 * Необходимо получить список пользователей,
 * которые состоят в группе начинающейся на "X"
 */


public class SomeConsumer {

    public List<User> consume(Stream<User> usersStream) {


        return usersStream
                .filter(
                        user -> user.groups()
                        .stream()
                        .anyMatch(group -> group.name().startsWith("X")))
                .toList();
    }

    record User(
            String username,
            Integer age,
            List<Group> groups) {
    }


    record Group(
            String name,
            String description) {
    }
}
