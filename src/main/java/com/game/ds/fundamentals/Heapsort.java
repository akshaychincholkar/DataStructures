package com.game.ds.fundamentals;

public class Heapsort{
    public static void main(String[] args){
        int[] a = {5,1,2,4,3};
        for(int n:a)System.out.print(n+" ");
        sort(a);
        System.out.println("After sort :");
        for(int n:a)System.out.print(n+" ");
    }
    public static void sort(int[] a){
        int n = a.length;

        // fill the array
        for(int i =0;i<n/2;i++){
            heapify(a,n,i);
        }

         for(int i=n-1;i>0;i--){
            // move current max to the end
            swap(a, i, 0);
            heapify(a, i, 0);
        }
}
    public static void heapify(int[] a, int n, int i){
        int lChild = 2*i+1;
        int rChild = 2*i +2;

        int largest = i;
        if(lChild < n && a[lChild]>a[i]) largest = lChild;
        else if(rChild<n && a[rChild]>a[i]) largest = rChild;

        if(largest !=i){
            swap(a,largest,i);
            heapify(a,n,largest);
        }
    }
    public  static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

