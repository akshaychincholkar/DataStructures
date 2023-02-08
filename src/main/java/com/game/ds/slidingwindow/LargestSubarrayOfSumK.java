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
    // function to find the length of longest
    // subarray having sum k
    static int lenOfLongSubarr(int A[], int N, int K)
    {

        int i = 0, j = 0, sum = 0;
        int maxLen = Integer.MIN_VALUE;

        while (j < N) {
            sum += A[j];
            if (sum < K) {
                j++;
            }
            else if (sum == K) {
                maxLen = Math.max(maxLen, j-i+1);
                j++;
            }
            else if (sum > K) {
                while (sum > K) {
                    sum -= A[i];
                    i++;
                }
                if(sum == K){
                    maxLen = Math.max(maxLen, j-i+1);
                }
                j++;
            }
        }
        return maxLen;
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
