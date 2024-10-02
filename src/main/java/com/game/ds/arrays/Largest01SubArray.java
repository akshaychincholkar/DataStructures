package com.game.ds.arrays;

import java.util.HashMap;
import java.util.Map;

public class Largest01SubArray {
    public static void main(String[] args) {
        int[]  a = {1,1,0,0,1,1,1,1,1,0,0,0,0,1};
//        int[] a = {1, 0, 1, 1, 1, 0, 0};
//        printLargestSubarray(a);
        System.out.println(findMaxLength(a));
    }
    public static int findMaxLength(int[] nums) {
        Map< Integer, Integer > map = new HashMap < > ();
        map.put(0, -1);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;
    }

    private static void printLargestSubarray(int[] a) {
        int l_ptr =-10 , r_ptr = -10;
        int new_l_ptr = -1, new_r_ptr = -1;
        int l_count = 0 , r_count = 0;
        int old_count =0 , new_count = 0;

        for (int i = 0; i < a.length; i++) {
            if(a[i] == 0 ) r_count++;
            else l_count++;

            if (l_count != 0 && r_count != 0) {
                if (l_count != r_count) {
                    new_r_ptr = i;
                    new_l_ptr = i - ((Math.min(l_count,r_count)-1) * 2 +1);
                    new_count = Math.min(l_count,r_count) * 2;
                    if (new_count > old_count && i == a.length-1) {
                        l_ptr = new_l_ptr;
                        r_ptr = new_r_ptr;
                        old_count = new_count;
                    }
                } else {
                    if (r_ptr == i - ((l_count * 2 - 1))-1) {
                        r_ptr = i;
                    } else {
                        r_ptr = i;
                        l_ptr = i - (l_count * 2 -1);
                    }
                    old_count = r_ptr-l_ptr+1;
                    new_l_ptr = new_r_ptr = new_count = l_count = r_count = 0;
                }

            }
        }
        System.out.println("Subarray is from index: "+l_ptr+ " to "+r_ptr);
    }
    public static int maxLen(int arr[], int n)
    {
        // Creates an empty hashMap hM

        HashMap<Integer, Integer> hM
                = new HashMap<Integer, Integer>();

        // Initialize sum of elements
        int sum = 0;

        // Initialize result
        int max_len = 0;
        int ending_index = -1;
        int start_index = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] == 0) ? -1 : 1;
        }

        // Traverse through the given array

        for (int i = 0; i < n; i++) {
            // Add current element to sum

            sum += arr[i];

            // To handle sum=0 at last index

            if (sum == 0) {
                max_len = i + 1;
                ending_index = i;
            }

            // If this sum is seen before,
            // then update max_len if required
            if (hM.containsKey(sum)) {
                if (max_len < i - hM.get(sum)) {
                    max_len = i - hM.get(sum);
                    ending_index = i;
                }
            }
            else // Else put this sum in hash table
                hM.put(sum, i);
        }

        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] == -1) ? 0 : 1;
        }

        int end = ending_index - max_len + 1;
        System.out.println(end + " to " + ending_index);

        return max_len;
    }

}
