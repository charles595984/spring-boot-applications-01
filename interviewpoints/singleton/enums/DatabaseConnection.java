package com.skcoder.interviewpoints.singleton.enums;

public enum DatabaseConnection {
    INSTANCE;

    public void doSomething() {
        System.out.println("Singleton via Enum");
    }

}
