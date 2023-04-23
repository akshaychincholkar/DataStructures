package com.game.ds.fundamentals;

public class MergeSort{
    public static void main(String[] args){
        int[] a = {5,1,2,4,3};
        for(int n:a)System.out.print(n+" ");
        sort(a,0,a.length-1);
        System.out.println("After sort");
        for(int n:a)System.out.print(n+" ");
    }
    public static void sort(int[] a,int s,int e){
        // calculate the mid
        if(s<e){
            int mid = s + (e-s)/2;
            sort(a,s,mid);
            sort(a,mid+1,e);

            // merge the elements
            merge(a,s,mid,e);
        }
    }
    public static void merge(int[] a, int s, int mid, int e){
        int n1 = mid - s +1;
        int n2 = e - mid;

        // create arrays with the above length : temp array
        int[] l = new int[n1];
        int[] r = new int[n2];

        // add the values to the arrays
        for(int i = 0 ; i<n1;i++) l[i] = a[s+i];
        for(int i = 0; i< n2;i++) r[i] = a[mid+1+i];

        // now merge the data
        int i = 0, j  = 0, k = s;
        while(i<n1 && j < n2){
            if(l[i]<l[j]){
                a[k] = l[i];
                i++;
            }else{
                a[k] = r[j];
                j++;
            }
            k++;
        }

        // adding the remaining
        while(i<n1) {
            a[k]= l[i];
            i++;
            k++;
        }
        while(j<n2){
            a[k]=r[j];
            j++;
            k++;
        }

    }
}

