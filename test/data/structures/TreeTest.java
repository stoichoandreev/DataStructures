package data.structures;

import org.junit.Test;

import static org.junit.Assert.*;

public class TreeTest {

    @Test
    public void test_tree_creation() {
        final Tree<Integer> tested =
                new Tree<>(new Tree.TreeNode<>(7),
                        new Tree.TreeNode<>(19,
                                new Tree.TreeNode<>(1),
                                new Tree.TreeNode<>(12),
                                new Tree.TreeNode<>(31)
                        ),
                        new Tree.TreeNode<>(21),
                        new Tree.TreeNode<>(14,
                                new Tree.TreeNode<>(23),
                                new Tree.TreeNode<>(6)
                        )
        );

        assertEquals(tested.getRoot().getValue().intValue(), 7);
        assertEquals(tested.getRoot().getChild(0).getValue().intValue(), 19);

        assertEquals(tested.getRoot().getChildrenCount(), 3);
        assertEquals(tested.getRoot().getChild(0).getChildrenCount(), 3);
        assertEquals(tested.getRoot().getChild(1).getChildrenCount(), 0);
        assertEquals(tested.getRoot().getChild(2).getChildrenCount(), 2);

        tested.print(Tree.DFS);
        tested.print(Tree.BFS);
    }

}