package com.game.ds.slidingwindow;

import java.util.HashMap;

public class LargestSubarrayOfSumK {
    public static void main(String[] args) {
        int[] a = {4,1,1,1,2,3,5,1,1,1,1,1};
//        int[] a = {4,2,1,1,1,3,2,5};
        int k = 5;
        int largest = lenOfLongSubarrGFG(a,a.length,k);
//          int largest = findLargestSubarray(a,k);

        System.out.println(largest);
    }

    /**
     * i = 4
     * j = 7
     * sum = 5
     * max =4
     * a = {4,2,1,1,1,3,2,5};
     */
    private static int findLargestSubarray(int[] a, int k) {
        int i =0 , j = 0 , sum = 0 ,max =0;
        while(i<a.length && j<a.length) {
            if(sum<k){
                sum+=a[j];
            }else if(sum==k){
                if(j-i+1>max){
                    max =j-i+1;
                }
            }else if(sum>k){
                while(sum>k){
                    sum-=a[i];
                    i++;
                }
            }
            j++;
        }
        return max;
    }
    static int lenOfLongSubarrGFG(int[] arr, int n, int k)
    {
        // HashMap to store (sum, index) tuples
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;

        // traverse the given array
        for (int i = 0; i < n; i++) {

            // accumulate sum
            sum += arr[i];

            // when subarray starts from index '0'
            if (sum == k)
                maxLen = i + 1;

            // make an entry for 'sum' if it is
            // not present in 'map'
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

            // check if 'sum-k' is present in 'map'
            // or not
            if (map.containsKey(sum - k)) {

                // update maxLength
                if (maxLen < (i - map.get(sum - k)))
                    maxLen = i - map.get(sum - k);
            }
        }

        return maxLen;
    }


}
