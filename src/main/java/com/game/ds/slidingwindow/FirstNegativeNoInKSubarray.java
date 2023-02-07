package com.game.ds.slidingwindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegativeNoInKSubarray {
    public static void main(String[] args) {
        int[] a = {12,-1,-7,8,-15,30,18,28};
        int window = 3;
        System.out.println("First -ve element list : "+getFirstNegativeArrayInSubarray(a,window));
//        printFirstNegativeIntegerGFG(a,a.length,window);
    }

    // function to find the first negative
// integer in every window of size k
    static void printFirstNegativeIntegerGFG(int arr[],
                                          int n, int k)
    {
        // A Double Ended Queue, Di that will
        // store indexes of useful array elements
        // for the current window of size k.
        // The useful elements are all negative integers.
        LinkedList<Integer> Di = new LinkedList<>();

        // Process first k (or first window)
        // elements of array
        int i;
        for (i = 0; i < k; i++)

            // Add current element at the rear of Di
            // if it is a negative integer
            if (arr[i] < 0)
                Di.add(i);

        // Process rest of the elements,
        // i.e., from arr[k] to arr[n-1]
        for ( ; i < n; i++)
        {
            // if Di is not empty then the element
            // at the front of the queue is the first
            // negative integer of the previous window
            if (!Di.isEmpty())
                System.out.print(arr[Di.peek()] + " ");

                // else the window does not have a
                // negative integer
            else
                System.out.print("0" + " ");

            // Remove the elements which are
            // out of this window
            while ((!Di.isEmpty()) &&
                    Di.peek() < (i - k + 1))
                Di.remove(); // Remove from front of queue

            // Add current element at the rear of Di
            // if it is a negative integer
            if (arr[i] < 0)
                Di.add(i);
        }

        // Print the first negative
        // integer of last window
        if (!Di.isEmpty())
            System.out.print(arr[Di.peek()] + " ");
        else
            System.out.print("0" + " ");
    }

    private static List getFirstNegativeArrayInSubarray(int[] a, int window) {
        List<Integer> returnList = new ArrayList<>();
        int start = 0, end = 0, neg = 0;
        Queue<Integer> queue = new LinkedList<>();
        int i;
        for( i = 0; i<window;i++){
            if(a[i]<0){
                ((LinkedList<Integer>) queue).add(i);
            }
        }

        for(;i<a.length;i++){
            if(!queue.isEmpty()){
                returnList.add(a[queue.peek()]);
            }else{
                returnList.add(0);
            }
            if(!queue.isEmpty() && queue.peek()<(i-window+1)){
                ((LinkedList<Integer>) queue).pop();
            }
            if(a[i]<0){
                ((LinkedList<Integer>) queue).add(i);
            }
        }
        if(queue.isEmpty())returnList.add(0);
        else returnList.add(a[((LinkedList<Integer>) queue).pop()]);
        return  returnList;
    }
    public static List<Integer> getNegativeFirstSubarray(int[] a, int k){
        int start=0, end=0;
        List<Integer> negList = new ArrayList<>();
        List<Integer> retList = new ArrayList<>();
        while(end<k){
            if(a[end] < 0) negList.add(a[end]);
            end++;
        }

        if(negList.size()!=0) retList.add(negList.get(0));
        else retList.add(0);
        while(end<a.length){
            if(negList.size()!=0) retList.add(negList.get(0));
            else retList.add(0);
            if(a[end] < 0 ) negList.add(a[end]);
            if(a[++start] < 0 ) negList.remove(0);
            end++;
        }
        return retList;
    }
}
