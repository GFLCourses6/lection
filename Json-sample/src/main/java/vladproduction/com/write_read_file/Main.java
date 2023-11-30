package vladproduction.com.write_read_file;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("src/main/java/vladproduction/com/app02/sportsmanList.json");

        Sportsman s1 = new Sportsman("athlete1",20,"ukr");
        Sportsman s2 = new Sportsman("athlete2",21,"swe");
        Sportsman s3 = new Sportsman("athlete3",22,"fin");

        List<Sportsman> sportsmanList = new ArrayList<>();
        sportsmanList.add(s1);
        sportsmanList.add(s2);
        sportsmanList.add(s3);

        for (Sportsman s: sportsmanList){
            System.out.println(s);
        }
        System.out.println("------------------------");
        ObjectMapper om = new ObjectMapper();

        String writtenDefault = om.writeValueAsString(sportsmanList);
        System.out.println("Default(write):============");
        System.out.println(writtenDefault);


        String writtenPretty = om
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(sportsmanList);
        System.out.println("Pretty(write):============");
        System.out.println(writtenPretty);

        System.out.println("(read)writtenDefault:============");
        System.out.println(om.readValue(writtenDefault, ArrayList.class));

        System.out.println("(read)writtenPretty:============");
        System.out.println(om.readValue(writtenPretty, ArrayList.class));



        //write to the file:
        om.writeValue(file, sportsmanList);

        //read from file:
        ArrayList<Sportsman> readValue = om.readValue(file,ArrayList.class);
        System.out.println("==============read from file:==========");
        System.out.println(readValue);

    }
}
