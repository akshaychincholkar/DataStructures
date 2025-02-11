package com.game.maang.arrays;

public class PairSum {
    public static void main(String[] args) {
        int[] a = {1,5,7,-1,5};
        System.out.println("Number of pairs with sum: "+getPairSum(a,6));
    }

    public static int getPairSum(int[] a,int sum) {
        int count = 0;
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i]+a[j]==sum)count++;
            }
        }
        return count;
    }
}
