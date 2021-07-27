package com.game.companies;

public class Halodoc_SortedRotatedSearch {
    public static void main(String[] args) {
        int[] a={10,11,12,1,2,3,4,5,6,7, 8,9};
        boolean found = searchInSortedRotatedArray(a,15,0,a.length-1);
        if(found)System.out.println("Present");
        else System.out.println("Absent");
    }

    public static boolean searchInSortedRotatedArray(int[] a, int element,int left,int right) {
        if(left>right) return false;
        int middle = (left+right)/2;
        if(a[middle]==element)return true;
        if(a[left]<=a[middle]){
            if(element>=a[left]&&element<=a[middle])
                return searchInSortedRotatedArray(a,element,left,middle-1);
            return searchInSortedRotatedArray(a,element,middle+1,right);
        }
        if(element>=a[middle]&&element<=a[right])
            return searchInSortedRotatedArray(a,element,middle+1,right);
        return searchInSortedRotatedArray(a,element,left,middle-1);
    }
}
