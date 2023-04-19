package com.game.ds.arrays;

public class BookAllocationProblem
{
    public static void main(String[] args) {
        int[] a = { 10, 20, 30 ,40,50};
        int k = 2; //students
        System.out.println("Min # of pages: "+getMinAllocations(a,k));
    }

    private static int getMinAllocations(int[] a, int k) {
        int sum = 0;
        for(int n: a)sum+=n;
        int s = 0;
        int e = sum;
        int mid = ( s + e ) /2;
        int ans = -1;
        while(s<=e){
            if( isPossible(a,k,mid)){
                ans = mid;
                e = mid - 1;
            }else{
                s = mid + 1;
            }
            mid = (s + e) / 2;
        }
        return ans;
    }

    private static boolean isPossible(int[] a, int k, int mid) {
        int studentCount = 1;
        int pagesCount = 0;
        for(int i =0 ; i<a.length;i++){
            if(pagesCount + a[i] <= mid){
                pagesCount += a[i];
            }else{
                studentCount++;
                if(studentCount>k || a[i] > mid) return false;
                pagesCount = a[i];
            }
        }
        return true;
    }
}
