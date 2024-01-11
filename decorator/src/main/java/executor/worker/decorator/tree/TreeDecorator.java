package executor.worker.decorator.tree;

public abstract class TreeDecorator implements Tree {
    private final Tree tree;

    protected TreeDecorator(Tree tree) {
        this.tree = tree;
    }

    @Override
    public String decorate() {
        return tree.decorate();
    }
}
