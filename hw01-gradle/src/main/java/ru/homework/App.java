/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ru.homework;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;


/**
 * To start the application:
 * ./gradlew build
 * java -jar ./L01-gradle/build/libs/gradleHelloWorld-0.1.jar
 * <p>
 * To unzip the jar:
 * unzip -l L01-gradle.jar
 * unzip -l gradleHelloWorld-0.1.jar
 */
public class App {
    public static void main(String... args) {
        List<Integer> example = new ArrayList<>();
        int min = 0;
        int max = 100;
        for (int i = min; i < max; i++) {
            example.add(i);
        }

        System.out.println(Lists.reverse(example));
    }
}
