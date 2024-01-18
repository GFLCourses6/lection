package org.example.spell;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component(value = "exampleComponent")
public class TestComponent {
    public String testParam;
    public List<String> listExample;
    public Map<String, Object> mapExample;

    public String getTestParam() {
        return testParam;
    }

    public void setTestParam(String testParam) {
        this.testParam = testParam;
    }

    public List<String> getListExample() {
        return listExample;
    }

    public void setListExample(List<String> listExample) {
        this.listExample = listExample;
    }

    public Map<String, Object> getMapExample() {
        return mapExample;
    }

    public void setMapExample(Map<String, Object> mapExample) {
        this.mapExample = mapExample;
    }

    public static boolean testMethod(){
        return true;
    }
}
