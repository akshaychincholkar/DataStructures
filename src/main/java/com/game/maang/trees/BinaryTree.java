package com.game.maang.trees;

import com.game.ds.queue.KQueuesInArray;

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
    public void preorder(Node cur){
        if(cur == null) return;
        System.out.print(cur.data+"\t");
        preorder(cur.left);
        preorder(cur.right);
    }
    public void postorder(Node cur){
        if(cur == null) return;
        postorder(cur.left);
        postorder(cur.right);
        System.out.print(cur.data+"\t");
    }
    public void levelOrder(Node root){
        if(root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        System.out.println();
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.print(cur.data+"\t");
            if(cur.left!=null)queue.add(cur.left);
            if(cur.right!=null)queue.add(cur.right);
        }
    }
    public static BinaryTree createTree(){

        BinaryTree tree = new BinaryTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(60);
        return tree;
    }
    public BinaryTree createIncompleteBT(){
        BinaryTree tree = new BinaryTree();
        Node node10 = new Node(10);
        tree.root = node10;

        Node node20 = new Node(20);
        node10.left = node20;
        Node node30 = new Node(30);
        node20.left = node30;
        Node node40 = new Node(40);
        node20.right = node40;
        Node node50 = new Node(50);
        node10.right = node50;
        Node node60 = new Node(60);
        node50.left = node60;
        Node node70 = new Node(70);
        node60.right = node70;
        return tree;
    }
    public int countNodes(Node root){
        if(root == null) return 0;
        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);
        return leftNodes+rightNodes+1;
    }
    public int countLeafNodes(Node root){
        if(root == null ) return 0;
        if(root.left == null && root.right == null) return 1;
        return countLeafNodes(root.left)+countLeafNodes(root.right);
    }
    public int height(Node cur){
        if(cur == null) return -1;
        int lHeight = height(cur.left);
        int rHeight = height(cur.right);
        return Math.max(lHeight,rHeight)+1;
    }
    public static void main(String[] args){

        BinaryTree tree = BinaryTree.createTree();
        tree.inorder(tree.root);
        tree.delete(20);
        System.out.println();
        tree.inorder(tree.root);

        BinaryTree tree2 = new BinaryTree();
        BinaryTree incompleteBT = tree2.createIncompleteBT();
        System.out.println();
        incompleteBT.inorder(incompleteBT.root);

        System.out.println("\nheight of incomplete BT: "+incompleteBT.height(incompleteBT.root));
        System.out.println(("Total nodes in complete BT :"+tree.countNodes(tree.root)));
        System.out.println(("Total nodes in BT :"+incompleteBT.countNodes(incompleteBT.root)));
        System.out.println(("Total leaf nodes in complete BT :"+tree.countLeafNodes(tree.root)));
        System.out.println(("Total leaf nodes in BT :"+incompleteBT.countLeafNodes(incompleteBT.root)));

        System.out.println("Preorder traversal of complete BT:");
        tree.preorder(tree.root);

        System.out.println("Postorder traversal of complete BT:");
        tree.postorder(tree.root);

        System.out.println("BFS/level order traversal of the tree :");
        tree.levelOrder(tree.root);
    }
}
