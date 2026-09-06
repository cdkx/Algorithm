package ru.eremin.ArrayTraversal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DisplayName("Тесты для IsLetterNext")
class IsLetterNextTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    private String runAndCapture() throws InterruptedException {
        IsLetterNext instance = new IsLetterNext();
        instance.printSequence();
        return outContent.toString();
    }

    @Test
    @DisplayName("Должна выводиться полная последовательность A1B2C3...Z26")
    void shouldPrintFullSequence() throws InterruptedException {
        String result = runAndCapture();

        StringBuilder expected = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            expected.append((char) ('A' + i)).append(i + 1);
        }
        assertEquals(expected.toString(), result);
    }

    @Test
    @DisplayName("Длина вывода — ровно 69 символа")
    void shouldHaveCorrectLength() throws InterruptedException {
        String result = runAndCapture();
        assertEquals(69, result.length());
    }

    @Test
    @DisplayName("Начинается с A1 и заканчивается на Z26")
    void shouldHaveCorrectBoundaries() throws InterruptedException {
        String result = runAndCapture();
        assertTrue(result.startsWith("A1"));
        assertTrue(result.endsWith("Z26"));
    }

    @Test
    @DisplayName("Буквы и цифры строго чередуются")
    void shouldAlternateCorrectly() throws InterruptedException {
        String result = runAndCapture();
        Pattern pattern = Pattern.compile("^([A-Z]\\d+){26}$");
        assertTrue(pattern.matcher(result).matches(),
                "Вывод не соответствует паттерну: " + result);
    }

    @Test
    @DisplayName("Все буквы идут в алфавитном порядке")
    void shouldHaveLettersInOrder() throws InterruptedException {
        String result = runAndCapture();
        int pos = 0;
        for (int i = 0; i < 26; i++) {
            char expected = (char) ('A' + i);
            assertEquals(expected, result.charAt(pos),
                    "На позиции " + pos + " ожидалась " + expected);
            pos += 1 + String.valueOf(i + 1).length();
        }
    }

    @Test
    @DisplayName("Все числа от 1 до 26 в порядке возрастания")
    void shouldHaveNumbersInOrder() throws InterruptedException {
        String result = runAndCapture();
        Matcher matcher = Pattern.compile("\\d+").matcher(result);

        int expected = 1;
        while (matcher.find()) {
            assertEquals(expected++, Integer.parseInt(matcher.group()));
        }
        assertEquals(27, expected, "Должно быть 26 чисел");
    }

    @Test
    @DisplayName("Каждая буква встречается ровно один раз")
    void shouldContainAllLettersExactlyOnce() throws InterruptedException {
        String result = runAndCapture();
        for (char c = 'A'; c <= 'Z'; c++) {
            long count = 0;
            for (int i = 0; i < result.length(); i++) {
                if (result.charAt(i) == c) {
                    count++;
                }
            }
            assertEquals(1, count, "Буква " + c + " должна встречаться 1 раз");
        }
    }

    @Test
    @DisplayName("Два экземпляра класса работают параллельно и независимо")
    void shouldBeIndependentAcrossInstances() throws InterruptedException {
        IsLetterNext instance1 = new IsLetterNext();
        IsLetterNext instance2 = new IsLetterNext();

        Thread t1 = new Thread(() -> {
            try {
                instance1.printSequence();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                instance2.printSequence();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        String result = outContent.toString();

        assertEquals(138, result.length(),
                "Два экземпляра должны вывести суммарно 104 символа");

        long aCount = result.chars().filter(ch -> ch == 'A').count();
        assertEquals(2, aCount, "Должно быть 2 буквы A (по одной от каждого экземпляра)");
    }

    @Test
    @DisplayName("Повторный вызов на том же экземпляре работает корректно")
    void shouldWorkOnMultipleCalls() throws InterruptedException {
        IsLetterNext instance = new IsLetterNext();

        instance.printSequence();
        String first = outContent.toString();
        assertTrue(first.startsWith("A1") && first.endsWith("Z26"));

        outContent.reset();

        instance.printSequence();
        String second = outContent.toString();
        assertTrue(second.startsWith("A1"));
        assertTrue(second.endsWith("Z26"));
        assertEquals(first, second, "Оба вызова должны давать одинаковый результат");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 10})
    @DisplayName("Детерминированный результат при многократных запусках")
    void shouldBeDeterministic(int iteration) throws InterruptedException {
        String result = runAndCapture();
        String expected = "A1B2C3D4E5F6G7H8I9J10K11L12M13N14O15P16Q17R18S19T20U21V22W23X24Y25Z26";
        assertEquals(expected, result, "Итерация " + iteration + " дала неверный результат");
        outContent.reset();
    }

    @Test
    @DisplayName("Прерывание потока корректно завершает выполнение")
    void shouldHandleInterruption() throws InterruptedException {
        IsLetterNext instance = new IsLetterNext();

        Thread worker = new Thread(() -> {
            try {
                instance.printSequence();
            } catch (InterruptedException ignored) {
            }
        });

        worker.start();
        Thread.sleep(10);
        worker.interrupt();

        worker.join(2000); // Ждем максимум 2 секунды
        assertFalse(worker.isAlive(), "Поток должен был завершиться после interrupt()");

        assertFalse(Thread.currentThread().isInterrupted(), "Главный поток не должен быть прерван");
    }

    @Test
    @DisplayName("Нет deadlock — завершается быстро")
    void shouldNotDeadlock() throws InterruptedException {
        long start = System.currentTimeMillis();
        new IsLetterNext().printSequence();
        long elapsed = System.currentTimeMillis() - start;

        assertTrue(elapsed < 2000, "Выполнение заняло " + elapsed + "мс — возможен deadlock");
    }
}
