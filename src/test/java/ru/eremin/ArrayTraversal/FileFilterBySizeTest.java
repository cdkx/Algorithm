package ru.eremin.ArrayTraversal;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileFilterBySizeTest {

    @Test
    void shouldReturnFilteredList() {
        SourceFile file1 = new SourceFile("file1.txt", 1024 * 500);
        SourceFile file2 = new SourceFile("file2.txt", 1024 * 1024 * 2);
        SourceFile file3 = new SourceFile("file3.txt", 1024 * 1024 * 3 / 2);
        List<SourceFile> input = List.of(file1, file2, file3);

        List<SourceFile> expected = List.of(file2, file3);

        List<SourceFile> actual = FileFilterBySize.filter(input);

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnFilteredList2() {
        SourceFile file1 = new SourceFile("a.txt", 100 * 1024);
        SourceFile file2 = new SourceFile("b.txt", 200 * 1024);
        List<SourceFile> input = List.of(file1, file2);

        List<SourceFile> expected = Collections.emptyList();

        List<SourceFile> actual = FileFilterBySize.filter(input);

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnFilteredList3() {
        SourceFile file1 = new SourceFile("video.mp4", 1024 * 1024 * 5);
        SourceFile file2 = new SourceFile("image.png", 1024 * 1024);
        List<SourceFile> input = List.of(file1, file2);

        List<SourceFile> expected = List.of(file1);

        List<SourceFile> actual = FileFilterBySize.filter(input);

        assertEquals(expected, actual);
    }
}
