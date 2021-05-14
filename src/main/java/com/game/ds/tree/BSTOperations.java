package com.game.ds.tree;

public class BSTOperations{
    public static void main(String[] args) {
        BinarySearchTree root = new BinarySearchTree(21);
        BinarySearchTree node1 = new BinarySearchTree(15);
        BinarySearchTree node2 = new BinarySearchTree(18);
        BinarySearchTree node3 = new BinarySearchTree(16);

        root.setLeft(node1);
        node1.setRight(node2);
        node2.setLeft(node3);

        BinarySearchTree.display(root);
        System.out.println("Height :"+BinarySearchTree.height(root));
    }
}
