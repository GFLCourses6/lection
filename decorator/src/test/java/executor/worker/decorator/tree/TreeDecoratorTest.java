package executor.worker.decorator.tree;

import executor.worker.decorator.tree.decoration.BubbleLights;
import executor.worker.decorator.tree.decoration.ChristmasTree;
import executor.worker.decorator.tree.decoration.Garland;
import executor.worker.decorator.tree.decoration.Tinsel;
import executor.worker.decorator.tree.decoration.TreeTopper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TreeDecoratorTest {

    private final List<Tree> trees = new ArrayList<>();

    @BeforeEach
    public void setup() {
        Tree christmasTree = new ChristmasTree();
        trees.add(new TreeTopper(christmasTree));
        trees.add(new Tinsel(christmasTree));
        trees.add(new Garland(christmasTree));
        trees.add(new BubbleLights(christmasTree));
    }


    @Test
    void testTreeDecorations() {
        for (Tree tree : trees) {
            String decoration = tree.decorate();
            assertNotNull(decoration);
            System.out.println(decoration);
        }
    }

    @Test
    void testTreeWithTreeTopperAndTinsel() {
        String decoration = "%s%s".formatted(trees.get(0).decorate(),
                                             trees.get(1).decorate());
        assertEquals("ChristmasTree with TreeTopperChristmasTree with Tinsel", decoration);
    }

    @Test
    void testTreeWithTinselAndGarland() {
        String decoration = "%s%s".formatted(trees.get(1).decorate(),
                                             trees.get(2).decorate());
        assertEquals("ChristmasTree with TinselChristmasTree with Garland", decoration);
    }

    @Test
    void testTreeWithTreeTopperAndGarland() {
        String decoration = "%s%s".formatted(trees.get(0).decorate(),
                                             trees.get(2).decorate());
        assertEquals("ChristmasTree with TreeTopperChristmasTree with Garland", decoration);
    }
}