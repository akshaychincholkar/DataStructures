package com.game.ds.arrays;

public class SearchInSortedRotatedArray {
    public static void main(String[] args) {
//        int[] a = {5, 6, 7, 8, 9, 10, 1, 2, 3};
//        int[] a = {1,2,3,4,5,6,7,8,9};
//        int[] a = {7,8,9,10,2,3,4};
//        int[] a = {3,1};
        int[] a = {5,1,3};
        System.out.println("Index: "+getPivotIndexUsingPointers(a));
        System.out.println("Binary search: "+searchElement(a,1));
    }

    private static int searchElement(int[] a,int key) {
        int pivotElement = getPivotIndexUsingPointers(a);
        if(key<=a[pivotElement-1]) return binarySearch(a,0,pivotElement-1,key);
        return binarySearch(a,pivotElement,a.length-1,key);
    }

    private static int binarySearch(int[] a, int l , int h, int key) {
        if(l>h) return -1;
        int mid = (l + h)/2;
        if(key == a[mid])return mid;
        if(key < a[mid]) return binarySearch(a,l,mid-1,key);
        else return binarySearch(a,mid+1,h,key);
    }
    public static int getPivotIndexUsingPointers(int[] a){
        int l = 0, h = a.length-1;
        int mid = l + ( h - l) / 2;
        while(l<h){
            if(a[mid]>=a[0]){
                l = mid+1;
            }else{
                h = mid;
            }
            mid = l + (h - l)/ 2;
        }
        return l;
    }
}
