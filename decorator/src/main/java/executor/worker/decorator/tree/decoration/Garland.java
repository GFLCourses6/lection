package executor.worker.decorator.tree.decoration;

import executor.worker.decorator.tree.Tree;
import executor.worker.decorator.tree.TreeDecorator;

public class Garland extends TreeDecorator {
    public Garland(Tree tree) {
        super(tree);
    }

    @Override
    public String decorate() {
        return "%s with %s".formatted(super.decorate(), decorateWithGarland());
    }

    private String decorateWithGarland() {
        return this.getClass().getSimpleName();
    }
}
