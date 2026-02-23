package com.skcoder.interviewpoints.threads;

class DeliveryAgent extends Thread {
    private String order;
    public DeliveryAgent(String order) {
        this.order = order;
    }

    public void run() {
        System.out.println("Agent picked up: " + order);
        try {
            Thread.sleep(2000); // Simulating delivery time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Order delivered: " + order);
    }
}

public class FoodDeliverySystemMain {
    void main() throws InterruptedException {
        DeliveryAgent agent1 = new DeliveryAgent("Pizza");
        DeliveryAgent agent2 = new DeliveryAgent("Burger");
        agent1.start(); // Runnable → Running
        agent2.start();
        agent1.join(); // Main thread waits until agent1 finishes
        agent2.join();
        System.out.println("All deliveries completed!");
    }
}
