package com.game.ds.dp;

public class TargetSumUsingPlusMinus {
    public static void main(String[] args) {
        //Target sum problem is same as number of subsets with given difference
        int[] a = {1,1,2,3};
        int difference = 1;
        int count = getTargetSumUsingPlusMinus(a,difference);
        System.out.println("Count is :"+count);
    }

    public static int getTargetSumUsingPlusMinus(int[] a, int difference) {
       return NumberOfSubsetsWithGivenDifference.getNumberOfSubsetsWithGivenDifference(a,difference);
    }
}
