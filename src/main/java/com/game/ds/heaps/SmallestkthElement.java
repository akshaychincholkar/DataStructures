package com.game.ds.heaps;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class SmallestkthElement {
    public static void main(String[] args) {


        int[] a = {4,13,21,12,2,30,1,9};
        int k = 3;//third smallest
        int kthSmallest = getKthSmallest(a,k);
        System.out.println("Kth smallest element is "+kthSmallest);

    }

    private static int getKthSmallest(int[] a, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=-0;i<a.length;i++){
            if(maxHeap.size()==k){
                if(maxHeap.peek()>a[i]){
                    System.out.println("Polled out: "+maxHeap.poll());
                    maxHeap.add(a[i]);
                    System.out.println("Added : "+a[i]);
                }
            }else {
                maxHeap.add(a[i]);
                System.out.println("Added :"+a[i]);
            }
            System.out.println("kth element: "+maxHeap.peek());
        }
        return maxHeap.peek();
    }
}
