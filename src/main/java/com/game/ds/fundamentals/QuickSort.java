package com.game.ds.fundamentals;

public class QuickSort {
    public static void main(String[] args) {
        int[] a={4,1,2,3,5,9,7};
        quicksort(a,0,a.length-1);
        for(int element:a) System.out.print(element+"\t");
    }

    public static void quicksort(int[] a, int low, int high) {
        if(low<high){
            int pi = partition(a,low,high);
            quicksort(a,low,pi-1);
            quicksort(a,pi+1,high);
        }
    }

    public static int partition(int[] a, int low, int high) {

        int pivot = a[high];
        int i=low-1;
        for(int j=low;j<high;j++){
            if(a[j]<pivot)swap(a,++i,j);
        }
        swap(a,++i,high);
        return i;
    }
    public static void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
