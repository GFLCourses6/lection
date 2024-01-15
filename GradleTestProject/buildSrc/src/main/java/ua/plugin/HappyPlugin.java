package ua.plugin;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

public class HappyPlugin extends DefaultTask {

    @Input
    public String kindWords = "Good luck my friend! You will succeed! I believe in you!";

    public String getKindWords() {
        return  kindWords;
    }

    @TaskAction
    public void printKindWords() {
        System.out.println(kindWords);
    }
}
