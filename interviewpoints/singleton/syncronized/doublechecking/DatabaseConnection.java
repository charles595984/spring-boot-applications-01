package com.skcoder.interviewpoints.singleton.syncronized.doublechecking;

public class DatabaseConnection {
    private static volatile DatabaseConnection instance;

    private DatabaseConnection() {
        // prevent reflection attack
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method");
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {                      // first check
            synchronized (DatabaseConnection.class) {
                if (instance == null) {              // second check
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

}
