package executor.worker.decorator.tree.decoration;

import executor.worker.decorator.tree.Tree;

public class ChristmasTree implements Tree {
    @Override
    public String decorate() {
        return "%s".formatted(this.getClass().getSimpleName());
    }
}
