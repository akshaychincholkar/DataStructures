package com.game.maang.arrays;

import com.game.ds.searching.BinarySearch;

public class SearchElementInRotatedArray {
    public static void main(String[] args) {
//        int[] a = {5,7,1,3,4};
        int[] a = {10,11,2,3,4,5,6,7,8,9};
        System.out.println(getPivot(a,0,a.length-1));
        System.out.println(search(a,4));
    }
    public static boolean search(int[] a,int value){
        int pivot = getPivot(a,0,a.length-1);
        if(a[pivot] == value)return true;
        if(a[0]==pivot) return false;
        if(value > a[pivot]) return binarySearch(a,0,pivot-1,value);
        else return binarySearch(a,pivot+1,a.length-1,value);

    }

    static boolean binarySearch(int[] arr, int lo, int hi, int x) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == x) return true;
            if (arr[mid] < x) lo = mid + 1;
            else hi = mid - 1;
        }
        return false;
    }
    public static int getPivot(int[] a,int l,int h){
        while(l<h){
            int mid = (l+h)/2;
            if(a[mid]<a[h]){
                h=mid-1;
            }
            else {
                l=mid+1;
            }
            if(l-1>h)return h;
        }
        return h;
    }
}
