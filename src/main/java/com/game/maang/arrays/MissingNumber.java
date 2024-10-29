package com.game.maang.arrays;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class MissingNumber{
    public static int getMissingNumber(int[] a){
        int[] hash = new int[a.length+1];
        for(int i =0;i<a.length;i++){
            hash[a[i]-1]++;
        }
        for(int i=0;i<hash.length;i++){
            if(hash[i] ==0) return i+1;
        }
        return -1;
    }
    public static int getMissingElementByMaths(int[] a){
        int sum =0;
        for(int element:a)sum +=element;
        int n = a.length+1;
        return ((n*(n+1))/2) - sum;
    }
    public static void display(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" |");
        }
        System.out.println();
    }
    public static void main(String[] args){
        int[] a = {5,4,3,1,2,7,9,8,10};
        display(a);
        System.out.println("Missing element: "+getMissingNumber(a));
        System.out.println("Missing element by Maths: "+getMissingElementByMaths(a));
    }
}
