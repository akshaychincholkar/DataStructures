package com.game.ds.heaps;

import java.util.*;

public class KFrequentNumbers {
    public static void main(String[] args) {
        int[] a= {1,1,1,5,2,2,3,4,2,3};
        int k = 3;
        List list = getFrequentKElements(a,k);
        System.out.println("key = frequency , value = Element");
        System.out.println(list);
    }

    private static List getFrequentKElements(int[] a, int k) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>();
        for(int i=0;i<a.length;i++){
            if(map.containsKey(a[i]))
                map.put(a[i],map.get(a[i])+1);
            else{
                map.put(a[i],1);
            }
        }
        for(Map.Entry entry: map.entrySet()){
            if(minHeap.size() == k){
                if(minHeap.peek().getKey()<(Integer) map.get(entry.getKey())){
                    System.out.println("Polling elements:"+minHeap.poll());
                    minHeap.add(new Pair((Integer) entry.getValue(),(Integer)entry.getKey()));
                }
            }else{
                minHeap.add(new Pair((Integer) entry.getValue(),(Integer)entry.getKey()));
            }
        }
        return Arrays.asList(minHeap);
    }
}
