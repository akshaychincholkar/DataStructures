package com.game.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private BinarySearchTree left;
    private BinarySearchTree right;
    private int value;

    public BinarySearchTree(BinarySearchTree left, BinarySearchTree right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }
    public boolean insert(int value){
        if(this.value>value){
            if(right!=null)insert(value);
            else new BinarySearchTree(value);
        }
        return false;
    }
    public static int height(BinarySearchTree root){
        if(root == null)return  0;
        return Math.max(height(root.left),height(root.right))+1;
    }
    public static void printAllNodes(BinarySearchTree parent){
        Queue<BinarySearchTree> queue= new LinkedList<BinarySearchTree>();
        ((LinkedList<BinarySearchTree>) queue).add(parent);
        while(!queue.isEmpty()){
            BinarySearchTree temp = queue.poll();
            System.out.println(temp+"\t");
            if(temp.left!=null){
                ((LinkedList<BinarySearchTree>) queue).add(temp.left);
            }
            if(temp.right!=null){
                ((LinkedList<BinarySearchTree>) queue).add(temp.right);
            }
        }
    }
    public static void display(BinarySearchTree root){
        int height = height(root);
        for(int i=1;i<=height;i++){
            printGivenLevel(root, i);
            System.out.println();
        }
    }

    private static void printGivenLevel(BinarySearchTree root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.println(root.getValue());
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }

    public BinarySearchTree(int value) {
        this.value = value;
    }

    public BinarySearchTree getLeft() {
        return left;
    }

    public void setLeft(BinarySearchTree left) {
        this.left = left;
    }

    public BinarySearchTree getRight() {
        return right;
    }

    public void setRight(BinarySearchTree right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value+"";
    }
}
