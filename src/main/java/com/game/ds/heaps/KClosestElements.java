package com.game.ds.heaps;

import java.util.*;

public class KClosestElements {
    public static void main(String[] args) {
        int[] a= {6,5,9,12,7,4,8};
        int k = 3;
        int element = 7;
        List list = getKClosentElements(a,k,element);
        System.out.println("Closest elements of "+element+" are:"+list);
    }

    private static List getKClosentElements(int[] a, int k, int element) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>(Collections.reverseOrder());
        for(int i =0 ;i< a.length;i++){
            if(maxHeap.size()==k){
                if(maxHeap.peek().getValue()> Math.abs(a[i]-element)){
                    maxHeap.add(new Pair(Math.abs(a[i]-element),a[i]));
                    System.out.println("Polling element: "+maxHeap.poll());
                }
            }else{
                maxHeap.add(new Pair(Math.abs(a[i]-element),a[i]));
                System.out.println("Adding element: "+Math.abs(a[i]-element)+" "+a[i]);
            }
        }
        return Arrays.asList(maxHeap);
    }
}
class Pair implements Comparable<Pair>{
    private Integer key;
    private int value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Pair o) {
        return this.key.compareTo(o.getKey());
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}