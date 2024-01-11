package executor.worker.decorator.tree.decoration;

import executor.worker.decorator.tree.Tree;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChristmasTreeTest {

    @Test
    void whenDecoratorsInjectedAtRuntimeThenConfigSuccess() {
        List<Tree> trees = new ArrayList<>();

        trees.add(new Garland(new ChristmasTree()));
        assertEquals("ChristmasTree with Garland", trees.get(0).decorate());
        trees.add(new BubbleLights(new Garland(new Garland(new ChristmasTree()))));
        assertEquals("ChristmasTree with Garland with Garland with BubbleLights",
                     trees.get(1).decorate());
    }
}
