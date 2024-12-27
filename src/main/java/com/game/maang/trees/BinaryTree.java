package com.game.maang.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree{
    class Node{
        int data;
        Node left,right;

        public Node(int data){
            this.data = data;
        }
    }
    Node root = null;

    public void insert(int data){
        Node node = new Node(data);
        if(root == null) {
            root=node;
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur.left == null){
                cur.left = node;
                return;
            }
            queue.add(cur.left);
            if(cur.right == null){
                cur.right = node;
                return;
            }
            queue.add(cur.right);
        }
    }
    public Node findDeepestNode(){
        Node cur = root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            cur = queue.poll();
            if(cur.left!=null)queue.add(cur.left);
            if(cur.right!=null)queue.add(cur.right);

        }
        return  cur;
    }
    public int findAndDeleteDeepestNode(){
        Node cur = root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            cur = queue.poll();
            if(cur.left!=null)queue.add(cur.left);
            if(cur.right!=null)queue.add(cur.right);

        }
        int value = cur.data;
        cur = null;
        return  value;
    }
    public void deleteDeepest(Node node){
        Queue<Node> queue = new LinkedList<>();
        if(node == root) root = null;
        queue.add(root);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur.left == node) cur.left = null;
            else if(cur.right == node ) cur.right = null;
            if(cur.left != null) queue.add(cur.left);
            if(cur.right != null) queue.add(cur.right);
        }
    }
    public boolean delete(int key){
        if(root == null) return false;
        Node deepest = findDeepestNode();
        if(root.data == key) root.data = deepest.data;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur.data == key){
                cur.data = deepest.data;
                deleteDeepest(deepest);
                return true;
            }
            if(cur.left != null)queue.add(cur.left);
            if(cur.right != null) queue.add(cur.right);
        }
        return false;
    }
    public void inorder(Node cur){
        if(cur == null) return;
        inorder(cur.left);
        System.out.print(cur.data+"\t");
        inorder(cur.right);
    }
    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(60);

        tree.inorder(tree.root);
        tree.delete(20);
        System.out.println();
        tree.inorder(tree.root);
    }
}
