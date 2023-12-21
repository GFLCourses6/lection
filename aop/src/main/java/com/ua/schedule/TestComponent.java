package com.ua.schedule;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TestComponent {
        private String testKey;
        private boolean flag;
        private String testParam;
        private List<String> list = new ArrayList<>();
        private Map<String, Object> map = new HashMap<>();

    public String getTestParam() {
        return testParam;
    }

    public void setTestParam(String testParam) {
        this.testParam = testParam;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public boolean flag() {
        return flag;
    }

    public String getTestKey() {
        return testKey;
    }
}
