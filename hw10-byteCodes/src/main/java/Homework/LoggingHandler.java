package Homework;

import Homework.annotations.Log;

import java.lang.reflect.Method;
import java.util.Arrays;

public class LoggingHandler implements java.lang.reflect.InvocationHandler {
    private final TestLogging myClass;

    LoggingHandler(TestLogging myClass) {
        this.myClass = myClass;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if(
                myClass
                .getClass()
                .getDeclaredMethod(
                        method.getName(),
                        method.getParameterTypes()
                )
                .isAnnotationPresent(Log.class)
        ){

            System.out.println("Invoking method:" + method.getName() + " params:" + Arrays.toString(args));
        }

        return method.invoke(myClass, args);
    }
}
