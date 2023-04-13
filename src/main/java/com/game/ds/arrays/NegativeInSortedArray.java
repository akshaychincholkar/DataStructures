package com.game.ds.arrays;

public class NegativeInSortedArray {
    public static void main(String[] args) {
        int[][] a= {{3  ,4  , 5 , 1, 9},
                    {5  ,6  ,-1 ,-1,-2},
                    {7  ,-8 ,-9 ,-10,-3},
                    {11,-12,-13,-14, -4},
                    {15,-16,-17,-18,-19}};

        int n = getNegatives(a,a.length,a.length);
        System.out.println("Total negative numbers : "+n);
    }

    private static int getNegatives(int[][] a, int n,int m) {
        int count = 0;
        for(int i = 0; i<a.length; i++){
            int rowIndex = getIndex(a[i],0,n-1,n);
            count += a[i].length - i;
        }
        return count;
    }

    private static int getIndex(int[] a, int i, int j ,int n) {
        if(i==j-1 ) {
            if(a[j] > 0) return j+1;
            if(a[i] < 0) return i;
            return i+1;
        }
        int mid = ( i+j ) / 2;
        if(a[mid] < 0) return getIndex(a,i,mid,n);
        else return getIndex(a,mid,j,n);

    }


}
