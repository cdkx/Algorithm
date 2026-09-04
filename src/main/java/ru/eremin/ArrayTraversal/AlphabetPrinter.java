package ru.eremin.ArrayTraversal;

/**
 * Вывести символы от A до Z
 * ~15 мин
 * Завершён
 * Паттерн:
 * Array Traversal / Linear Scan
 * Подсказка:
 * Не ищите готовые значения. Подумайте, как устроены символы в Java и как можно пройти диапазон значений.
 * <p>
 * Что изучить:
 * char как числовое значение;
 * циклы;
 * преобразование типов.
 */

public class AlphabetPrinter {
    public static void main(String[] args) {

        for (int i = 0; i < 26; i++) {
            char x = (char) ('A' + i);
            System.out.print(x + " ");
        }

        System.out.println();

        for (char c = 'A'; c <= 'Z'; c++) {
            System.out.print(c + " ");
        }
    }
}
