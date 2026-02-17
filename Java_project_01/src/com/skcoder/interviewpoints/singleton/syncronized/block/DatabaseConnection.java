package com.skcoder.interviewpoints.singleton.syncronized.block;

public class DatabaseConnection {
    private final String databaseUrl;

    private DatabaseConnection() {
        this.databaseUrl = "jdbc:mysql://localhost:3306/mydb";
        System.out.println("Database Connection establised");
    }

    private static volatile DatabaseConnection instance = null;

    public static DatabaseConnection getInstance() {
        if(instance == null) {
            synchronized(DatabaseConnection.class) {
                if(instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }
}
