package com.skcoder.interviewpoints.maps;

import java.util.List;

record Customer(String name, List<Order> orders) {
}

record Order(int id, double amount) {
}

public class MapAndFlapMapRealWorldExample {
    void main() {
        List<Customer> customers = List.of(
                new Customer("Alice", List.of(
                        new Order(1, 120.0),
                        new Order(2, 80.0))),
                new Customer("Bob", List.of(
                        new Order(3, 200.0))),
                new Customer("Danny", List.of(
                        new Order(5, 150.0),
                        new Order(6, 80.0),
                        new Order(7, 80.0)))
        );

        // Extract just customer names
        List<String> customerNames = customers.stream()
                .map(Customer::name)   // Each Customer -> String
                .toList();
        System.out.println("Customer Names: " + customerNames);

        // Extract all orders across all customers
        List<Double> orderAmounts = customers.stream()
                .flatMap(customer -> customer.orders().stream()) // Flatten List<Order>
                .map(Order::amount)
                .toList();
        System.out.println("Order Amounts: " + orderAmounts);

        List<String> res = customers.stream()
                .flatMap(customer -> customer.orders().stream())   // Flatten orders
                .filter(order -> order.amount() > 100)             // Predicate
                .map(order -> "Order #" + order.id() + " $" + order.amount()) // Function
                .toList();
        System.out.println("AA: " + res);
    }
}
