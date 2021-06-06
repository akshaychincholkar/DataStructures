package com.game.ds.dp;

public class NumberOfSubsetsWithGivenDifference {
    public static void main(String[] args) {
        int[] a = {1,1,2,3};
        int difference = 1;
        int count = getNumberOfSubsetsWithGivenDifference(a,difference);
        System.out.println("Count is :"+count);
    }

    public static int getNumberOfSubsetsWithGivenDifference(int[] a, int difference) {
        int sum = 0;
        for(int i=0;i<a.length;i++)sum+=a[i];
        int s1 = (difference + sum )/2;

        return SubsetSumCount.getSubsetSumCount(a,s1);
    }
}
