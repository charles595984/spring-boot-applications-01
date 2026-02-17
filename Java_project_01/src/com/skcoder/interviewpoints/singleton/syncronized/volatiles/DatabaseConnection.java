package com.skcoder.interviewpoints.singleton.syncronized.volatiles;

public class DatabaseConnection {
    private String jdbcUrl;

    private DatabaseConnection() {
        this.jdbcUrl = "jdbc:mysql://localhost:3306/care_dev";
        System.out.println("Database Connected!"+ jdbcUrl);
    }

    private static volatile DatabaseConnection instance = null;

    public static DatabaseConnection getInstacne() {

        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }
}
