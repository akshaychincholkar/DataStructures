package com.game.ds.dp;

public class EqualSumPartition {
    public static void main(String[] args) {
        int[] a= {1,5,11,5};
        boolean isPresent = isEqualSumPartition(a);
        System.out.println("Equal sum Partition: "+isPresent);
    }

    public static boolean isEqualSumPartition(int[] a) {
        int sum = 0;
        for(int i=0;i<a.length;i++){
            sum += a[i];
        }
        if(sum%2!=0) return false;
        else{
            return SubsetSum.isSubsetFound(a,sum/2);
        }
    }
}
