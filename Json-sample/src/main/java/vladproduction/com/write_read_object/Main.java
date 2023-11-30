package vladproduction.com.write_read_object;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        Person person1 = new Person("person1",21);
        Person person2 = new Person("person2",22);
        Person person3 = new Person("person3",23);


        System.out.println("----------standard---sout---------");
        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);

        //write
        System.out.println("-------write as json------------");
        ObjectMapper om = new ObjectMapper();
        System.out.println(om.writeValueAsString(person1));
        System.out.println(om.writeValueAsString(person2));
        System.out.println(om.writeValueAsString(person3));


        //read - need to be default constructor
        System.out.println("--------------read as json-----------------");
        Person person_1 = om.readValue(om.writeValueAsString(person1),Person.class);
        Person person_2 = om.readValue(om.writeValueAsString(person2),Person.class);
        Person person_3 = om.readValue(om.writeValueAsString(person3),Person.class);

        System.out.println(person_1);
        System.out.println(person_2);
        System.out.println(person_3);
    }
}
