package vladproduction.com.jackson_date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EventTest {

    @Test
    public void test1() throws JsonProcessingException, ParseException {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));

        Date date = df.parse("01-01-1970 01:00");
        Event event = new Event("party", date);

        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(event);
        System.out.println(value);
    }

    @Test
    public void test2()throws JsonProcessingException, ParseException {

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));

        String toParse = "01-01-1970";
        Date date = df.parse(toParse);
        Event event = new Event("party", date);

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        mapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
        String result = mapper.writeValueAsString(event);
        System.out.println(result);


    }

}