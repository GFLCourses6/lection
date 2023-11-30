package vladproduction.com.superheroes;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ObjectMapper om = new ObjectMapper();
        File file = new File("src/main/java/com/vladproduction/jackson/superheroes/superheroes.json");
        SuperHeroSquad readValue = om.readValue(file,SuperHeroSquad.class);
        System.out.println(readValue);

    }
}
