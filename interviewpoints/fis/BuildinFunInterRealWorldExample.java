package com.skcoder.interviewpoints.fis;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

record Order(int id, String status, double amount) {
}

public class BuildinFunInterRealWorldExample {
    void main() {
        List<Order> orders = List.of(
                new Order(1, "COMPLETED", 120.50),
                new Order(2, "PENDING", 75.00),
                new Order(3, "COMPLETED", 200.00),
                new Order(4, "CANCELLED", 50.00),
                new Order(5, "RETURNED", 80.00)
        );

        Predicate<Order> isCompleted = order -> "COMPLETED".equals(order.status());

        Function<Order, String> orderSummary = order ->
                "Order #" + order.id() + " Amount: $" + order.amount();

        Consumer<String> logSummary = summary -> System.out.println("Processed: " + summary);

        // Stream pipeline
        orders.stream()
                .filter(isCompleted)       // Predicate
                .map(orderSummary)         // Function
                .forEach(logSummary);      // Consumer
    }
}
