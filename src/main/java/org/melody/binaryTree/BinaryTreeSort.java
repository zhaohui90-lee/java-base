package org.melody.binaryTree;

import java.util.ArrayList;

/**
 * @author chatGPT
 * @since 2023/2/5
 */
class BinaryTreeSort {
    Node root;

    BinaryTreeSort() {
        root = null;
    }

    void insert(int data) {
        root = insertRec(root, data);
    }

    Node insertRec(Node node, int data) {
        if (node == null) {
            node = new Node(data);
            return node;
        }

        if (data < node.data)
            node.left = insertRec(node.left, data);
        else if (data > node.data)
            node.right = insertRec(node.right, data);

        return node;
    }

    ArrayList<Integer> inorder() {
        ArrayList<Integer> sortedArray = new ArrayList<>();
        inorderRec(root, sortedArray);
        return sortedArray;
    }

    void inorderRec(Node node, ArrayList<Integer> sortedArray) {
        if (node != null) {
            inorderRec(node.left, sortedArray);
            sortedArray.add(node.data);
            inorderRec(node.right, sortedArray);
        }
    }

    public static void main(String[] args) {
        BinaryTreeSort tree = new BinaryTreeSort();

        int[] array = {5, 2, 9, 1, 3, 8, 10};
        for (int data : array)
            tree.insert(data);

        ArrayList<Integer> sortedArray = tree.inorder();
        System.out.println("Sorted array: " + sortedArray);
    }
}

