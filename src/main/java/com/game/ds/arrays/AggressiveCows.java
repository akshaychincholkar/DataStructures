package com.game.ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AggressiveCows {
    public static void main(String[] args) {
//        int[] a = {2,1,5,6,2,3};
        // 4 2 1 3 6
        int[] a = {4,2,1,3,6};
        int cows = 2;
        System.out.println("Aggressive cows: "+getAggresiveCows(a,2));
    }

    private static int getAggresiveCows(int[] a, int k) {
        int s = 0;
        int sum = 0;
        for(int n: a) sum+=n;
        int e = sum;
        List<Integer> list = Arrays.stream(a).boxed().sorted().collect(Collectors.toList());
        a = list.stream().mapToInt(Integer::intValue).toArray();
        int ans = Integer.MIN_VALUE;
        int mid = s + (e-s)/2;
        while(s<=e){
            if(isPossible(a,k,mid)){
                s = mid +1;
                ans = mid;
            }else{
                e = mid - 1;
            }
            mid = s + (e-s)/2;
        }
        return ans;
    }

    private static boolean isPossible(int[] a, int k, int mid) {
            int count = a[0];
            int cows = 1;
            for(int i = 0 ;i<a.length;i++){
                if(count - a[i] >= mid){
                    cows++;
                    count = a[i];
                    if(cows == k) return true;
                }
                    count+=a[i];

            }
            return false;
    }

}
