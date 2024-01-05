package com.ua.webdriver;

import com.codeborne.selenide.WebDriverRunner;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Common {
    public static final String baseUrl = "http://the-internet.herokuapp.com";

//    WebDriverRunner.setWebDriver()

    public static File generateFile() {
        try {
            File file = File.createTempFile("file", ".txt");
            try (PrintWriter writer = new PrintWriter(file)) {
                writer.println("This is a file content.");
            }
            return file;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void sleep(Long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            Thread.interrupted();
            System.out.println(e.getMessage());
        }
    }
}
