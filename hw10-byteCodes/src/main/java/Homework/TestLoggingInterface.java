package Homework;

import Homework.annotations.Log;

public interface TestLoggingInterface {

    void calculation(int param);

    void calculation(int param, int secondParam);

    void calculationWithoutLogging(int param);
}
