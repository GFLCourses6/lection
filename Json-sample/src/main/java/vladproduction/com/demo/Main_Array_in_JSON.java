package vladproduction.com.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main_Array_in_JSON {

    public static void main(String[] args) throws IOException {

        File file = new File("src/main/java/vladproduction/com/app03/arrayJSON.txt");

        ArrayList list = new ArrayList();
        list.add(0,"one");
        list.add(1,"two");
        list.add(2,"tree");
        list.add(3,"four");
        list.add(4,"five");

        System.out.println(list.size());
        System.out.println(list);

        ObjectMapper objectMapper = new ObjectMapper();

        String listWrite = objectMapper.writeValueAsString(list);
        System.out.println(listWrite);

        ArrayList arrayList = objectMapper.readValue(listWrite,ArrayList.class);
        System.out.println(arrayList);


        //to file:
        objectMapper.writeValue(file,list);

        //from file:
        ArrayList listFromFile = objectMapper.readValue(file,ArrayList.class);
        System.out.println(listFromFile);
    }
}
