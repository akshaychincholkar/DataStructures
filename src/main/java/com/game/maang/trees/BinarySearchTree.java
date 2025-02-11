package com.game.maang.trees;

public class BinarySearchTree {
    class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data = data;
        }
    }
    Node root;
    public void add(int data){
        Node node = new Node(data);
        if(root == null){
            root = node;
            return;
        }
        insert(root,node);
    }
    public void insert(Node root,Node node){
        if(node.data<=root.data){
            if(root.left == null){
                root.left = node;
                return;
            }
            insert(root.left,node);
        }else{
            if(root.right == null){
                root.right = node;
                return;
            }
            insert(root.right,node);
        }
    }
    public void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data+"\t");
        inorder(root.right);
    }
    public boolean search(int value){
        return isFound(this.root,value);
    }

    private boolean isFound(Node root, int value) {
        if(root == null) return false;
        if(root.data == value) return true;
        if(root.data > value) return isFound(root.left,value);
        return isFound(root.right,value);
    }
    public int smallest(){
        if(this.root == null) return -1;
        return getSmallest(this.root);
    }

    private int getSmallest(Node root) {
        if(root.left == null) return root.data;
        return getSmallest(root.left);
    }
    private int greatest(){
        return getGreatest(this.root);
    }

    private int getGreatest(Node root) {
        if(root.right == null) return root.data;
        return getGreatest(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(5);
        bst.add(4);
        bst.add(1);
        bst.add(10);
        bst.add(8);
        bst.add(15);
        bst.add(6);

        bst.inorder(bst.root);
        System.out.println();
        System.out.println("Value 1 present:"+(bst.search(1)?"Yes":"No"));
        System.out.println("Value 12 present:"+(bst.search(12)?"Yes":"No"));
        System.out.println("Value 10 present:"+(bst.search(10)?"Yes":"No"));
        System.out.println("Smallest element in the BST: "+bst.smallest());
        System.out.println("Greatest element in the BST: "+bst.greatest());
    }
}
