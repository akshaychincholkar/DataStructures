package com.game.companies;

import java.util.LinkedList;
import java.util.Queue;

class BinaryLinkedTree{
    public int data;
    public BinaryLinkedTree left;
    public BinaryLinkedTree right;
    public BinaryLinkedTree nextRight;

    BinaryLinkedTree(int data){
        this.data = data;
    }
    public void setLeft(BinaryLinkedTree left){
        this.left = left;
    }
    public void setRight(BinaryLinkedTree right){
        this.right = right;
    }
    public void setNext(BinaryLinkedTree next){
        this.nextRight = next;
    }
    public BinaryLinkedTree processRightChildLinking(BinaryLinkedTree root){
        Queue<BinaryLinkedTree> parentQueue= new LinkedList<>();
        Queue<BinaryLinkedTree> childrenQueue= new LinkedList<>();

        ((LinkedList<BinaryLinkedTree>) parentQueue).add(root);
        if(root.left!=null)((LinkedList<BinaryLinkedTree>) childrenQueue).add(root.left);
        if(root.right!=null)((LinkedList<BinaryLinkedTree>) childrenQueue).add(root.right);
        int height = getHeight(root);
        boolean isEmptyChild=true;
        for(int i=0;i<height;i++){
            while(!childrenQueue.isEmpty()){
                if(isEmptyChild){
                    parentQueue.removeAll(parentQueue);
                    isEmptyChild=false;
                }
                BinaryLinkedTree temp = childrenQueue.remove();
                temp.nextRight = childrenQueue.peek();
                ((LinkedList<BinaryLinkedTree>) parentQueue).add(temp);
            }
            //O(n + m)
            while(!parentQueue.isEmpty()){
                BinaryLinkedTree temp = childrenQueue.remove();
                if(temp.left!=null)((LinkedList<BinaryLinkedTree>) childrenQueue).add(temp.left);
                if(temp.right!=null)((LinkedList<BinaryLinkedTree>) childrenQueue).add(temp.right);
            }
            isEmptyChild=true;
        }
        return root;
    }
    public int getHeight(BinaryLinkedTree root){
        if(root==null)return 0;
        return 1+Math.max(getHeight(root.left),getHeight(root.right));
    }
}

public class Client{
    public static void main(String[] a){
//        BinaryLinkedTree tree = new BinaryLinkedTree(1);
        System.out.println("Test");

    }

}