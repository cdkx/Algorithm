package ru.eremin.ArrayTraversal;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileFilterBySizeTest {

    @Test
    void shouldReturnFilteredList() {
        FileFilterBySize.SourceFile file1 = new FileFilterBySize.SourceFile("file1.txt", 1024 * 500);
        FileFilterBySize.SourceFile file2 = new FileFilterBySize.SourceFile("file2.txt", 1024 * 1024 * 2);
        FileFilterBySize.SourceFile file3 = new FileFilterBySize.SourceFile("file3.txt", 1024 * 1024 * 3 / 2);
        List<FileFilterBySize.SourceFile> input = List.of(file1, file2, file3);

        List<FileFilterBySize.SourceFile> expected = List.of(file2, file3);

        List<FileFilterBySize.SourceFile> actual = FileFilterBySize.filter(input);

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnFilteredList2() {
        FileFilterBySize.SourceFile file1 = new FileFilterBySize.SourceFile("a.txt", 100 * 1024);
        FileFilterBySize.SourceFile file2 = new FileFilterBySize.SourceFile("b.txt", 200 * 1024);
        List<FileFilterBySize.SourceFile> input = List.of(file1, file2);

        List<FileFilterBySize.SourceFile> expected = Collections.emptyList();

        List<FileFilterBySize.SourceFile> actual = FileFilterBySize.filter(input);

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnFilteredList3() {
        FileFilterBySize.SourceFile file1 = new FileFilterBySize.SourceFile("video.mp4", 1024 * 1024 * 5);
        FileFilterBySize.SourceFile file2 = new FileFilterBySize.SourceFile("image.png", 1024 * 1024);
        List<FileFilterBySize.SourceFile> input = List.of(file1, file2);

        List<FileFilterBySize.SourceFile> expected = List.of(file1);

        List<FileFilterBySize.SourceFile> actual = FileFilterBySize.filter(input);

        assertEquals(expected, actual);
    }
}
