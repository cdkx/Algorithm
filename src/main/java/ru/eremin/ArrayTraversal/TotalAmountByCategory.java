package ru.eremin.ArrayTraversal;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TotalAmountByCategory {
    /**
     *
     * Отфильтровать транзакции с отрицательной суммой (учитывать только положительные расходы).
     * Сгруппировать оставшиеся транзакции по категории.
     * Для каждой категории вычислить общую сумму.
     * Дополнительно, округлить до 2-х знаков после запятой
     * Вернуть Map<String, Double>, где ключ – категория, значение – сумма.
     */

    Map<String, Double> totalAmountByCategory(List<Transaction> transactions) {
        return transactions.stream()
                .filter(transaction -> transaction.amount() > 0)
                .collect(
                        Collectors.groupingBy(
                                Transaction::category,
                                TreeMap::new,
                                Collectors.collectingAndThen(
                                        Collectors.summingDouble(Transaction::amount),
                                        sum -> Math.round(sum * 100.00) / 100.00

                                )
                        )
                );

    }

    record Transaction(
            String category,
            double amount) {
    }

}
