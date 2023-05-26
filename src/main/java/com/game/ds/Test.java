package com.game.ds;

public class Test {
    public static void main(String[] args) {
        int[] a = { 10, 20,30,40};
        int k = 2;
        System.out.println("books allocation: "+bookAllocation(a,k));
    }

    public static int bookAllocation(int[] a, int k) {
        int sum =0;
        for(int element: a) sum+=element;
        return solve(a,k,0,sum);
    }
    private static int solve(int[] a,int k,int l,int r){
        int mid = ( l + r )/2+1;
        if(l<r){
            if(isValid(a,k,mid)){
                return solve(a,k,l+1,mid);
            }else{
                return solve(a,k,mid,r);
            }
        }
        return l;
    }
    private static boolean isValid(int[] a, int k , int mid){
        int sum = 0;
        int parts =1;
        for(int i = 0 ;i<a.length;i++){
            sum+=a[i];
            if(sum>mid){
                sum = a[i];
                parts++;
            }
            if(parts>k) return false;
        }
        return true;
    }
}
