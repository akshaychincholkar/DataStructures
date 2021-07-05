package com.game.ds.arrays;

public class MauntainRange {
    public static void main(String[] args) {
//        int[] a={1,6,5,4,3,2,1,0};
        int[] a={2,1};
        boolean isMountain = isMantainRange(a);
        System.out.println("Is mountain:"+isMountain);
    }

    private static boolean isMantainRange(int[] a) {
        if(a.length<3)return false;
        int i=0;
        while(i<a.length&&i+1<a.length&&a[i]<a[i+1]){
            i++;
        }
        if(i==0 || i+1>=a.length)return false;
        while(i<a.length&&i+1<a.length&&a[i]>a[i+1]){
            i++;
        }
        if(i+1==a.length)return true;
        return false;
    }
}
