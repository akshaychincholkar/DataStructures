package com.game.ds.arrays;

public class PivotSumIndex {
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        System.out.println("Index: "+getPivotSumIndex(nums));

    }

    private static int getPivotSumIndex(int[] nums) {
        int total_count =0;
        for(int num: nums)total_count+=num;
        if(0 == total_count - nums[0])return 0;
        int left_sum = 0;
        for(int i=1;i<nums.length;i++){
            left_sum  += nums[i-1];
            if(2*left_sum == total_count - nums[i]) return i;
        }
        return -1;
    }

}
