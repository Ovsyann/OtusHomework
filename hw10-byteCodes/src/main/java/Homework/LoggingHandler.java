package Homework;

import Homework.annotations.Log;

import java.lang.reflect.Method;
import java.util.Arrays;

public class LoggingHandler implements java.lang.reflect.InvocationHandler {

    private final TestLoggingInterface instance;
    private final Class<?> instanceClass;

    LoggingHandler(TestLoggingInterface instance) {

        this.instance = instance;
        instanceClass = instance.getClass();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if(
                instanceClass
                        .getDeclaredMethod(
                                method.getName(),
                                method.getParameterTypes()
                        )
                        .isAnnotationPresent(Log.class)
        )
        {
            System.out.println("Invoking method:" + method.getName() + " params:" + Arrays.toString(args));
        }

        return method.invoke(instance, args);
    }
}
