package executor.worker.decorator.tree.decoration;

import executor.worker.decorator.tree.Tree;
import executor.worker.decorator.tree.TreeDecorator;

public class TreeTopper extends TreeDecorator {
    public TreeTopper(Tree tree) {
        super(tree);
    }

    @Override
    public String decorate() {
        return "%s with %s".formatted(super.decorate(), decorateWithTopper());
    }

    private String decorateWithTopper() {
        return this.getClass().getSimpleName();
    }
}
