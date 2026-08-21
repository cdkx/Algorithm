package ru.eremin.ArrayTraversal;

import java.util.List;

// Ограничения:
// - Необходимо отфильтровать список файлов по размеру.
// - Оставить только те файлы, у которых размер больше 1 MB.
// - 1 MB = 1024 * 1024 bytes.
// - Использовать класс SourceFile как модель.
//
// Примеры:
//
// input:
// [file1.txt(500KB), file2.mp4(2MB), file3.jpg(1.5MB)]
// output:
// [file2.mp4, file3.jpg]
//
// input:
// [a.txt(100KB), b.txt(200KB)]
// output:
// []
//
// input:
// [video.mp4(5MB), image.png(1MB)]
// output:
// [video.mp4]

public class FileFilterBySize {

    public static void main(String[] args) {
        // ваш код здесь
    }

    public static List<SourceFile> filter(List<SourceFile> files) {

        return files.stream()
                .filter(o -> o.getSizeBytes() > 1024 * 1024)
                .toList();


    }
}

// Модель файла
class SourceFile {

    private String name;
    private long sizeBytes;

    public SourceFile(String name, long sizeBytes) {
        this.name = name;
        this.sizeBytes = sizeBytes;
    }

    public String getName() {
        return name;
    }

    public long getSizeBytes() {
        return sizeBytes;
    }
}
