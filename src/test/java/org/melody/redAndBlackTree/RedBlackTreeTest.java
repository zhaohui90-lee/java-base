package org.melody.redAndBlackTree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lizhaohui
 * @since 2023/2/5
 */
class RedBlackTreeTest {

    @Test
    void insert() {
        RedBlackTree tree = new RedBlackTree();
        tree.insert(50);
        tree.insert(40);
        tree.insert(60);
        tree.insert(30);
        tree.insert(45);
        tree.insert(55);
        tree.insert(65);
        List<Integer> result = tree.inorder();
        Integer[] expected = new Integer[]{30, 40, 45, 50, 55, 60, 65};
        assertArrayEquals(expected, result.toArray(new Integer[result.size()]));
    }

    @Test
    public void testInsertDuplicate() {
        RedBlackTree tree = new RedBlackTree();
        tree.insert(50);
        tree.insert(40);
        tree.insert(60);
        tree.insert(50);
        List<Integer> result = tree.inorder();
        Integer[] expected = new Integer[]{40, 50, 50, 60};
        assertArrayEquals(expected, result.toArray(new Integer[result.size()]));
    }
}