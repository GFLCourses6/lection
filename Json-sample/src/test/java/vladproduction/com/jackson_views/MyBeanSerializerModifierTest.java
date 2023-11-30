package vladproduction.com.jackson_views;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;

class MyBeanSerializerModifierTest {

    @Test
    public void test()
            throws JsonProcessingException {
        User user = new User(1, "John");
        SerializerFactory serializerFactory = BeanSerializerFactory.instance
                .withSerializerModifier(new MyBeanSerializerModifier());

        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializerFactory(serializerFactory);

        String result = mapper
                .writerWithView(Views.Public.class)
                .writeValueAsString(user);

        assertThat(result, containsString("JOHN"));
        assertThat(result, containsString("1"));

        System.out.println(result);
    }

}