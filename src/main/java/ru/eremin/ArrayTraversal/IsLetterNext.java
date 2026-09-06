package ru.eremin.ArrayTraversal;

/**
 * Есть 2 потока:
 * один из них печатает на экран символы ABCD...
 * Другой поток печатает цифры 1234...
 * Нужно написать код так, чтобы вывод на экран был гарантированно последовательным: A1B2C3...
 * <p>
 * Thread letters = new Thread(()->{});
 * Thread numbers = new Thread(()->{});
 */


public class IsLetterNext {
    boolean isLetterTurn = false; //volatile не нужно, переменную меняем внутри synchronized

    public static void main(String[] args) {
        try {
            new IsLetterNext().printSequence();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void printSequence() throws InterruptedException {
        Object lock = new Object();

        Thread letters = new Thread(() -> {
            for (char i = 'A'; i <= 'Z'; i++) {
                synchronized (lock) {
                    while (isLetterTurn) { //while вместо if спасёт разработчика от спонтанного пробуждения потока
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    System.out.print(i);
                    isLetterTurn = true;
                    lock.notifyAll();
                }
            }
        });

        Thread numbers = new Thread(() -> {
            for (int i = 1; i < 27; i++) {
                synchronized (lock) {
                    while (!isLetterTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    System.out.print(i);
                    isLetterTurn = false;
                    lock.notifyAll();
                }
            }
        });

        letters.start();
        numbers.start();
        letters.join();
        numbers.join();
    }
}
