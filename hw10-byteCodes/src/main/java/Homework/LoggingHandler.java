package Homework;

import Homework.annotations.Log;

import java.lang.reflect.Method;
import java.util.Arrays;

public class LoggingHandler implements java.lang.reflect.InvocationHandler {

    private final TestLoggingInterface instance;
    private final Method[] methods;

    LoggingHandler(TestLoggingInterface instance) {

        this.instance = instance;
        methods = instance.getClass().getDeclaredMethods();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if(hasLogAnnotation(method)){

            System.out.println("Invoking method:" + method.getName() + " params:" + Arrays.toString(args));
        }

        return method.invoke(instance, args);
    }

    private boolean hasLogAnnotation(Method interfaceMethod){

        for (Method method: methods) {

            if (method.getName().equals(interfaceMethod.getName())
                    && Arrays.equals(method.getParameterTypes(), interfaceMethod.getParameterTypes())){

                return method.isAnnotationPresent(Log.class);
            }
        }

        return false;
    }
}
