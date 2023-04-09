package homework;

import homework.annotations.After;
import homework.annotations.Before;
import homework.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {

    public static void runAllTests(String testClassName) throws ClassNotFoundException {

        initiate(testClassName);
    }


    private static void initiate(String className) throws ClassNotFoundException {

        Class<?> type = Class.forName(className);//(Class<? extends Object>) ReflectionHelper.instantiate(Class.forName(className));
        List<String> tests = new ArrayList<>();
        List<String> befores = new ArrayList<>();
        List<String> afters = new ArrayList<>();
        for(Method method : type.getDeclaredMethods()){

            if(method.isAnnotationPresent(Before.class)){
                befores.add(method.getName());
            }

            if(method.isAnnotationPresent(Test.class)){
                tests.add(method.getName());
            }

            if(method.isAnnotationPresent(After.class)){
                afters.add(method.getName());
            }
        }

        runTests(type, tests, befores, afters);
    }

    private static void runTests(Class<?> type, List<String> tests,
                                 List<String> befores, List<String> afters) {

        TestResult result = new TestResult();
        for (String methodName : tests) {
            runTest(ReflectionHelper.instantiate(type), methodName, befores, afters, result);
        }

        printResult(result);
    }

    private static void runTest(Object instance, String methodName,
                                List<String> befores, List<String> afters, TestResult results) {

        try{
            for (String name : befores) {
                ReflectionHelper.callMethod(instance, name);
            }

            ReflectionHelper.callMethod(instance, methodName);

            for (String name : afters) {
                ReflectionHelper.callMethod(instance, name);
            }

            results.add("Success " + methodName);
        }
        catch(Exception e){
            results.add("Fail " + methodName + ": " + e);
        }
    }

    private static void printResult(TestResult results) {

        for (String result : results.getResults()) {
            System.out.println(result);
        }
    }
}
