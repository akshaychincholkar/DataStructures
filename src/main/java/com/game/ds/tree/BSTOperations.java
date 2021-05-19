package com.game.ds.tree;

import com.game.ds.searching.BinarySearch;

import java.io.PrintStream;

public class BSTOperations{
    public static void main(String[] args) {
        BinarySearchTree root = new BinarySearchTree(21);
        BinarySearchTree node1 = new BinarySearchTree(15);
        BinarySearchTree node2 = new BinarySearchTree(18);
        BinarySearchTree node3 = new BinarySearchTree(16);

        root.setLeft(node1);
        node1.setRight(node2);
        node2.setLeft(node3);

        System.out.println("****************Basic created tree*******************");
        BinarySearchTree.display(root);

        System.out.println("****************Height of a tree*******************");
        System.out.println("Height :"+BinarySearchTree.height(root));

        System.out.println("****************Tree traversal*******************");
        System.out.println("Preorder");
        BinarySearchTree.preorder(root);
        System.out.println();
        System.out.println("Inorder");
        BinarySearchTree.inorder(root);
        System.out.println();
        System.out.println("Postorder");
        BinarySearchTree.postorder(root);

        System.out.println("****************BST tree creation with insertion*******************");
        root.insert(root,new BinarySearchTree(20));
        root.display(root);

    }
}
