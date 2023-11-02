package vladproduction.com.app04.model;

public class Train {

    private final String name;

    public Train(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
