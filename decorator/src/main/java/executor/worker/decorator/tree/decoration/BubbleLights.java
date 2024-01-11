package executor.worker.decorator.tree.decoration;

import executor.worker.decorator.tree.Tree;
import executor.worker.decorator.tree.TreeDecorator;

public class BubbleLights
        extends TreeDecorator {
    public BubbleLights(Tree tree) {
        super(tree);
    }

    @Override
    public String decorate() {
        return "%s with %s".formatted(super.decorate(), decorateWithBubbleLights());
    }

    private String decorateWithBubbleLights() {
        return this.getClass().getSimpleName();
    }
}
