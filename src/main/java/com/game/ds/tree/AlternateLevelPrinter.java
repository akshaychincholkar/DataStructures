package com.game.ds.tree;

public class AlternateLevelPrinter {
    public static void main(String[] args) {
        Tree four = new Tree(4);
        Tree five = new Tree(5);
        Tree six = new Tree(6);
        Tree seven = new Tree(7);
        Tree two = new Tree(2,four,five);
        Tree three = new Tree(3,six,seven);
        Tree root = new Tree(1,two,three);
        root.preorder(root);
        System.out.println("Height of tree is "+getHeight(root));
        alternateLevel(root);
    }
    public static int getHeight(Tree root){
        if(root == null )return 0;
        return 1+ Math.max( getHeight(root.left),getHeight(root.right));
    }
    public static void alternateLevel(Tree root) {
        int height = getHeight(root);
        boolean toogle=true;
        for(int i = 1;i<=height;i++){
            printLevel(i,toogle,root);
            toogle=!toogle;
        }
    }
    public static void printLevel(int height,boolean toggle,Tree root){
        if(root == null || height == 1) {
            System.out.print(root.data+"  ");
            return;
        }
        if(toggle){
            printLevel(height-1,toggle,root.left);
            printLevel(height-1,toggle,root.right);
        }else{
            printLevel(height-1,toggle,root.right);
            printLevel(height-1,toggle,root.left);
        }
    }

    static class Tree{
        int data;
        Tree left,right;
        Tree(int data){
            this.data = data;
        }
        Tree(int data,Tree left,Tree right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
        public void preorder(Tree root){
            if(root == null) return;
            System.out.print(root.data+"  ");
            preorder(root.left);
            preorder(root.right);
        }
    }
}
