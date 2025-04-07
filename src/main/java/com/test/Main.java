package com.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("db.url", "db.username", "db.password");
            System.out.println("Hello, World!");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}