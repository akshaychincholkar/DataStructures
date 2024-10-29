package com.game.maang.arrays;

public class SecondLargest {
    public static int getSecondLargestElement(int[] a){
        for(int i=0;i<2;i++)
            for(int j=0;j<a.length-i-1;j++){
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        return a[a.length-2];
    }
    public static int getSecondLargestUsingVars(int[] a){
        if(a.length == 0 || a.length == 1) return 0;
        if(a.length == 2) return a[0]>a[1]?a[1]:a[0];
        int first = 0, second = 0;
        for(int element: a){
            if(element>first){
                second = first;
                first = element;
            }else if(element<first && element>second)second = element;
        }
        return second;
    }
    public static void main(String[] args) {
        int[] a = {5,4,1,3,2};
        System.out.println("Second largest element: "+getSecondLargestElement(a));
        System.out.println("Second largest element: "+getSecondLargestUsingVars(a));
    }
}
