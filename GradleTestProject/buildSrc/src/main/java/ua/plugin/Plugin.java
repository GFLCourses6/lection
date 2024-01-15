package ua.plugin;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

public class Plugin extends DefaultTask {

    @Input
    public String message = "My first Java task using Gradle";

    public String getMessage() {
        return message;
    }

    @TaskAction
    public void printMessage() {
        System.out.println(message);
    }
}
