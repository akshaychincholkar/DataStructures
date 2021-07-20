package com.game.ds.arrays;

import com.game.ds.sorting.QuickSort;

import java.util.*;

public class TripletSumZero {
    public static void main(String[] args) {
        int[] a={-1,0,1,2,-1,-4};
        System.out.println(threeSum(a));
    }
    public static List<List<Integer>> threeSum(int[] a) {
        Set<List<Integer>> set=new HashSet<>();
        QuickSort.quicksort(a,0,a.length-1);
        int r=a.length-1;
        for(int i=0;i<a.length;i++){

            int l=i+1;
            while(l<r){
                if(a[l]+a[r]+a[i]<0)l++;
                else if(a[l]+a[r]+a[i]>0)r--;
                else{
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(a[i]);tempList.add(a[l]);tempList.add(a[r]);
                    set.add(tempList);
                    l++;
                }
            }
        }

        return new ArrayList(set);
    }
}
