package com.game.ds.tree;

public class DiameterOfTreeDP {
    public static void main(String[] args) {
        BinarySearchTree root = new BinarySearchTree(30);
        root.insert(root,new BinarySearchTree(15));
        root.insert(root,new BinarySearchTree(9));
        root.insert(root,new BinarySearchTree(6));
        root.insert(root,new BinarySearchTree(12));
        root.insert(root,new BinarySearchTree(10));
        root.insert(root,new BinarySearchTree(11));
        root.insert(root,new BinarySearchTree(24));
        root.insert(root,new BinarySearchTree(27));
        root.insert(root,new BinarySearchTree(26));
        root.insert(root,new BinarySearchTree(30));
        root.insert(root,new BinarySearchTree(29));
        root.insert(root,new BinarySearchTree(33));

        root.display(root);

        int diameter = getDiameter(root);
        System.out.println("Diameter: "+diameter);
    }

    private static int getDiameter(BinarySearchTree root) {
        int diameter=0;
        if(root == null) return 0;

        int lHeight = BinarySearchTree.height(root.getLeft());
        int rHeight = BinarySearchTree.height(root.getRight());

        int lDiameter = getDiameter(root.getLeft());
        int rDiameter = getDiameter(root.getRight());

        return Math.max(lHeight+rHeight+1,Math.max(lDiameter,rDiameter));
    }
}
