package com.game.ds.arrays;

public class BitonicArray {
    public static void main(String[] args) {
        int[] a = {1,4,7,15,12,9};
        System.out.println("Bitonic :"+getPeak(a));
    }

    private static int getPeak(int[] a) {
        int s = 0, e = a.length-1;
        int mid = s + (e-s)/2;
        while(s<=e){
            if(mid!=0 && mid!=a.length-1){
                if(a[mid]>a[mid-1] && a[mid]>a[mid+1]){
                    return a[mid];
                }else if(a[mid]<a[mid+1]){
                    s = mid +1;
                }else{
                    e = mid -1;
                }
            }
            mid = s + (e-s)/2;
        }
        return -1;
    }
}
