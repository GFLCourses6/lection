package executor.worker.decorator.tree.decoration;

import executor.worker.decorator.tree.Tree;
import executor.worker.decorator.tree.TreeDecorator;

public class Tinsel
        extends TreeDecorator {
    public Tinsel(Tree tree) {
        super(tree);
    }

    @Override
    public String decorate() {
        return "%s with %s".formatted(super.decorate(), decorateWithTinsel());
    }

    private String decorateWithTinsel() {
        return this.getClass().getSimpleName();
    }
}
