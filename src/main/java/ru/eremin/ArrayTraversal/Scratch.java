package ru.eremin.ArrayTraversal;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class Scratch {
    private record Book(String author, String name) {

    }


    public static void main(String[] args) {
        Set<Book> books = Set.of(
                new Book("Author1", "Name1"),
                new Book("Author1", "Name2"),
                new Book("Author2", "Name3"),
                new Book("Author2", "Name4"),
                new Book("Author3", "Name5"));
        Map<String, List<String>> mapping = mapping(books);
    }

    //Получить список наименований книг по каждому автору в виде мапы

    static Map<String, List<String>> mapping(Set<Book> books) {
        return books.stream()
                .collect(Collectors.groupingBy(
                        Book::author,
                        Collectors.mapping(Book::name, Collectors.toList())));


    }
}
