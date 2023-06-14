package Homework;

import Homework.annotations.Log;

class TestLogging implements TestLoggingInterface {
    @Override
    public void calculation(int param) {
        System.out.println("calculation invoked");
    };

    @Log
    @Override
    public void calculation(int param, int secondParam) {
        System.out.println("calculation 2 without logging invoked");
    };

    @Override
    public void calculationWithoutLogging(int param) {
        System.out.println("calculation without logging invoked");
    };
}
