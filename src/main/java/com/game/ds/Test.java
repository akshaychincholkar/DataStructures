package com.game.ds;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args){
//        int[] a = {5,1,2,4,3};
        int[] a = {1,2,3,4,5};
        for(int n:a)System.out.print(n+" ");
        sort(a);
        System.out.println("After sort");
        for(int n:a)System.out.print(n+" ");
    }
    public static void sort(int[] a){
        boolean flag = true;
        for(int i = 0 ;i<a.length;i++){
            for(int j = 0; j < a.length - i - 1;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = false;
//                    System.out.println("Om");
                }
                if(flag) break;
            }
        }
    }

}
