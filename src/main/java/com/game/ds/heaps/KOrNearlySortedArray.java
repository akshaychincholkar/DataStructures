package com.game.ds.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KOrNearlySortedArray {
    public static void main(String[] args) {
        int[] a= {6,5,3,2,8,10,9};
        int k = 3;
        List list = getNearlySortedArray(a,k);
        System.out.println(list);
    }

    public static List getNearlySortedArray(int[] a, int k) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<a.length;i++){
            if(minHeap.size()==k){
                minHeap.add(a[i]);
                list.add(minHeap.poll());
            }else{
                minHeap.add(a[i]);
            }
        }
        list.addAll(minHeap);
        return list;
    }
}
