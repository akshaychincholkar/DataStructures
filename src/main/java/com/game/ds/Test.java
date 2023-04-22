package com.game.ds;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args){
        int[] a = {3,1,2,6,4,5,2,1,8}; // output: 3,6,6,6,5,5,8
        int k = 3;
        System.out.println("Max sum of subarray: "+getMaxSum(a,k));
    }
    public  static List<Integer> getMaxSum(int[] a, int k){
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int i = 0;
        //calculate for first window
        int max = 0;
        for(i = 0;i<k;i++){
            if(!queue.isEmpty() && a[queue.peek()]<a[i]){
                queue.removeAll(queue);
                queue.add(i);
            }else{
                queue.add(i);
            }
        }
        if(!queue.isEmpty())list.add(a[queue.peek()]);
        else list.add(0);
        for(;i<a.length;i++){
            int s = i - k;
            if(!queue.isEmpty() && s==queue.peek()){
                queue.remove();
            }
            if(!queue.isEmpty() && a[queue.peek()] < a[i]){
                queue.removeAll(queue);
                queue.add(i);
            }
            if(!queue.isEmpty()) list.add(a[queue.peek()]);
            else  list.add(0);
        }
        return list;
    }

}
