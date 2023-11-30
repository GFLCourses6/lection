package vladproduction.com.jackson_views;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static java.util.function.Predicate.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    public void test() throws JsonProcessingException {

        //If we use the Public view to serialize – only id and name will be serialized to JSON:

        Item item = new Item(2, "book", "John");

        ObjectMapper mapper = new ObjectMapper();
        String result = mapper
                .writerWithView(Views.Public.class)
                .writeValueAsString(item);

        assertThat(result, containsString("book"));
        assertThat(result, containsString("2"));

        System.out.println(result);

        //assertThat(result, not(containsString("John")));

    }

    @Test
    public void test2() throws JsonProcessingException {

        //But if we use the Internal view to perform the serialization, all fields will be part of the JSON output:

        Item item = new Item(2, "book", "John");

        ObjectMapper mapper = new ObjectMapper();
        String result = mapper
                .writerWithView(Views.Internal.class)
                .writeValueAsString(item);

        assertThat(result, containsString("book"));
        assertThat(result, containsString("2"));

        assertThat(result, containsString("John"));

        System.out.println(result);
    }

}