package vladproduction.com.demo;

import com.cedarsoftware.util.io.JsonReader;
import com.cedarsoftware.util.io.JsonWriter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Simple {
    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        Foo foo = new Foo(1, "first");

        String jsonStr = mapper.writeValueAsString(foo);
        Foo result = mapper.readValue(jsonStr, Foo.class);
        System.out.println("result = " + result);


        //json-io
        Foo foo2 = new Foo(1, "first");

        String jsonStr2 = JsonWriter.objectToJson(foo);
        Foo result2 = (Foo) JsonReader.jsonToJava(jsonStr2);
        System.out.println("result2 = " + result2);

    }


}


