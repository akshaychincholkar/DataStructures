package com.game.ds.heaps;

import java.util.*;

public class KLargestElements {
    public static void main(String[] args) {
        int[] a={2,1,30,12,21,9,6,24};
//        int[] a  = {3,1,2};
        int k = 3;
        List list = getKLargestElements(a,k);
        System.out.println(list);
    }

    private static List getKLargestElements(int[] a, int k) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<a.length;i++){
            if(minHeap.size()==k){
                if(minHeap.peek() < a[i]){
                    System.out.println("Polling element:"+minHeap.poll());
                    minHeap.add(a[i]);
                }
            }else{
                minHeap.add(a[i]);
            }
        }
        return Arrays.asList(minHeap);
    }
}
