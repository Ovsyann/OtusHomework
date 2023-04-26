package Homework;

import java.lang.reflect.Proxy;

public class Creator {

    public static TestLoggingInterface create() {

        java.lang.reflect.InvocationHandler handler = new LoggingHandler(new TestLogging());
        return (TestLoggingInterface) Proxy.newProxyInstance(Creator.class.getClassLoader(),
                new Class<?>[]{TestLoggingInterface.class}, handler);
    }
}
