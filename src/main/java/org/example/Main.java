package org.example;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import static java.lang.System.out;

@ApplicationPath("/api")
public class Main extends Application {
    public static void main(String... args) {
        out.println(2);
    }
}