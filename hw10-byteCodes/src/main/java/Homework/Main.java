package Homework;


public class Main {

    public static void main(String[] args) {
        TestLoggingInterface myClass = Creator.create();
        myClass.calculation(1);
        myClass.calculation(2, 3);
        myClass.calculationWithoutLogging(4);
    }
}
