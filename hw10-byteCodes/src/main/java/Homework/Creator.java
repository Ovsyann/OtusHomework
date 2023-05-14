package Homework;

import java.lang.reflect.Proxy;

public class Creator {

    public static TestLoggingInterface create(TestLoggingInterface implementation) {

        java.lang.reflect.InvocationHandler handler = new LoggingHandler(implementation);
        return (TestLoggingInterface) Proxy.newProxyInstance(Creator.class.getClassLoader(),
                new Class<?>[]{TestLoggingInterface.class}, handler);
    }
}
