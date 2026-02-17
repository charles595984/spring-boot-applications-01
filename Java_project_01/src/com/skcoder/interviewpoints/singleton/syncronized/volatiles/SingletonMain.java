package com.skcoder.interviewpoints.singleton.syncronized.volatiles;

public class SingletonMain {
    void main() {
        DatabaseConnection conn01 = DatabaseConnection.getInstacne();
        DatabaseConnection conn02 = DatabaseConnection.getInstacne();
        System.out.println(conn01 == conn02);
    }
}
