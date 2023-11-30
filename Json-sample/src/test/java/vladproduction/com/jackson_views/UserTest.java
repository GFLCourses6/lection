package vladproduction.com.jackson_views;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static java.util.function.Predicate.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void testSerialize()throws JsonProcessingException {

        User user = new User(1, "John");

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);

        String result = mapper
                .writerWithView(Views.Public.class)
                .writeValueAsString(user);

        System.out.println("resultNoId = " + result); //no id --> no annotation: @JsonView(Views.Public.class) for id;
        System.out.println("result = " + result); //want id --> put annotation: @JsonView(Views.Public.class) for id;

        assertThat(result, containsString("John"));

    }

    @Test
    public void testDeserialize() throws IOException {

        //JSON Views to deserialize objects – specifically, a User instance:

        String json = "{\"id\":1,\"name\":\"John\"}"; //need to be careful with double-quotes

        System.out.println(json);

        ObjectMapper mapper = new ObjectMapper();
        User user = mapper
                .readerWithView(Views.Public.class)
                .forType(User.class)
                .readValue(json); //need to hae default constructor

        assertEquals(1, user.getId());
        assertEquals("John", user.getName());
    }



}