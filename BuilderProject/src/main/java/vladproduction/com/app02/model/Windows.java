package vladproduction.com.app02.model;

public class Windows {

    private final WindowFrame windowFrame;

    public Windows(WindowFrame windowFrame) {
        this.windowFrame = windowFrame;
    }

    public WindowFrame getWindowFrame() {
        return windowFrame;
    }

    @Override
    public String toString() {
        return "" + windowFrame;
    }

    public enum WindowFrame{
        WOOD, PLASTIC
    }
}
