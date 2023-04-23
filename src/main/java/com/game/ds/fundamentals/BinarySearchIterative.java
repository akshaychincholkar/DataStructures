package com.game.ds.fundamentals;

public class BinarySearchIterative {
    public static void main(String[] args){
        int[] a = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("Binary search for 2: "+solve(a,10));
    }
    public static int solve(int[] a,int value){
        int s = 0, e = a.length-1;
        int mid = (s + e)/2;
        while(s<=e){
            if(a[mid] == value){
                return mid;
            }else if(value < a[mid] ) e = mid - 1;
            else s = mid+1;
            mid = s + (e-s)/2;
        }
        return -1;
    }
}
