package org.melody.redAndBlackTree;

/**
 * @author lizhaohui
 * @since 2023/2/5
 */
public class Node {

    int key;
    Color color;
    Node left, right, parent;

    Node(int key) {
        this.key = key;
        color = Color.RED;
    }
}
