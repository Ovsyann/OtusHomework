package ru.homework;
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
        List<String> example = List.of(new String[]{
                "One", "Two", "Three"
        });

        HelloOtus builder = new HelloOtus();
        System.out.println("No Guava: " + builder.concatenateStringsWithDelimiterNoGuava(example,","));
        System.out.println("Guava: " + builder.concatenateStringsWithDelimiterGuava(example,","));
    }
}
