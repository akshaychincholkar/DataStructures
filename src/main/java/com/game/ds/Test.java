package com.game.ds;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    // Driver code
    public static void main(String args[]){
        int[] a = {1,2,3,4,5};
        rotateArray(a,2);
        System.out.println(Arrays.stream(a).boxed().collect(Collectors.toList()));
    }
    public static void rotateArray(int[] a, int k){
        if(k>= a.length)return;
        for(int i = 0 ;i<k;i++){
            int temp = a[0];
            for(int j = 1; j<a.length;j++){
                a[j-1] = a[j];
            }
            a[a.length-1] = temp;
        }
    }
}
