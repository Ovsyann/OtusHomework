package homework;

import java.util.ArrayList;
import java.util.List;

public class TestResult {

    private final List<String> container = new ArrayList<>();
    public void add(String testResult) {

        container.add(testResult);
    }

    public List<String> getResults(){

        return container;
    }
}
