package org.example.webdriver.jsonExample;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDataBinder {
    private static final String jsonExample = "{\n" +
            "  \"id-key\": 1,\n" +
            "  \"test\": 1,\n" +
            "  \"value\": \"example\"\n" +
            "}";

    public static void main(String[] args) throws JsonProcessingException {
        // map json by class fields
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonExample jsonExample1 = objectMapper.readValue(jsonExample, JsonExample.class);
        System.out.println(jsonExample1.toString());

        JsonExample jsonExample2 = new JsonExample(2, "Test", "Type");
        String s = objectMapper.writeValueAsString(jsonExample2);
        System.out.println(s);
    }

    private static class JsonExample{

        @JsonProperty(value = "id-key") // map key in json to id
        private Integer id;
        private String value;
        private String type;

        public JsonExample(){

        }
        public JsonExample(Integer id, String value, String type) {
            this.id = id;
            this.value = value;
            this.type = type;
        }
        public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public String getValue() {
            return value;
        }
        public void setValue(String value) {
            this.value = value;
        }
        public String getType() {
            return type;
        }
        public void setType(String type) {
            this.type = type;
        }
        @Override
        public String toString() {
            return "JsonExample{" +
                    "id=" + id +
                    ", value='" + value + '\'' +
                    ", type='" + type + '\'' +
                    '}';
        }
    }
}
