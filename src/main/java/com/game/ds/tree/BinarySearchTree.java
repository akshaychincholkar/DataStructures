package com.game.ds.tree;

import com.game.ds.stack.InorderTraversalUsingStack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
    private BinarySearchTree left;
    private BinarySearchTree right;
    private int value;

    public BinarySearchTree(BinarySearchTree left, BinarySearchTree right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }
    public void insert(BinarySearchTree root,BinarySearchTree node){
        if(root.value < node.value){
            if(root.right == null){
                root.right = node;
                return;
            }
            insert(root.right,node);
        }else{
            if(root.left == null){
                root.left = node;
                return;
            }
            insert(root.left,node);
        }
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
            System.out.print(temp+"\t");
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
            System.out.print(root.getValue()+"\t");
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

    public static void inorder(BinarySearchTree root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.getValue()+"\t");
        inorder(root.right);
    }
    public static void preorder(BinarySearchTree root){
        if(root == null) return;
        System.out.print(root.getValue()+"\t");
        preorder(root.left);
        preorder(root.right);
    }
    public static  void postorder(BinarySearchTree root){
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.getValue()+"\t");
    }
    public static void inorderUsingStack(Stack stack, BinarySearchTree root){
        if(root == null)return;
        stack.push(root);
        inorderUsingStack(stack,root.left);
        BinarySearchTree node = (BinarySearchTree) stack.pop();
        System.out.print(node.getValue()+"\t");
        inorderUsingStack(stack,node.right);
    }
    public static void BFS(BinarySearchTree root){
        Queue<BinarySearchTree> queue = new LinkedList<>();
        ((LinkedList<BinarySearchTree>) queue).add(root);
        while(!queue.isEmpty()){
            BinarySearchTree temp = queue.remove();
            System.out.println(temp.getValue());
            if(temp.left!=null)((LinkedList<BinarySearchTree>) queue).add(temp.left);
            if(temp.right!=null)((LinkedList<BinarySearchTree>) queue).add(temp.right);
        }
    }
}
