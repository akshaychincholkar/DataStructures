package com.game.ds.slidingwindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxElementSubarrayWindow {
    public static void main(String[] args) {
        int[] a = {1,3,4,-3,-5,3,6,7};
        int window = 3;

        List list = getMaxElementSubarray(a,window);
        System.out.println(list);
    }

    private static List getMaxElementSubarray(int[] a, int window) {
        List list = new ArrayList();
        int i;
        Queue<Integer> queue = new LinkedList();
        int max = a[0];((LinkedList) queue).add(a[0]);
        for(i=1;i<window;i++){
            if(max<a[i]){
                queue.removeAll(queue);
                max = i;
            }
            ((LinkedList) queue).add(i);
        }
        list.add(a[max]);//a = {1,3,4,-3,-5,3,6,7};
        for(;i<a.length;i++){
            if(queue.peek()<(i-window+1))((LinkedList<Integer>) queue).remove();
            if(a[i]>a[queue.peek()]){
                queue.removeAll(queue);
            }
                ((LinkedList<Integer>) queue).add(i);
            list.add(a[((LinkedList<Integer>) queue).peek()]);

        }
        return list;
    }
    public static List<Integer> getMaxSubArray(int[] a, int k){
        List<Integer> list = new ArrayList<>();
        List<Integer> ret = new ArrayList<>();
        int i;
        for(i = 0; i< k; i++){
            if(list.size() == 0) {
                list.add(a[i]);
                continue;
            }
            if(list.get(0)<a[i]){
                list.clear();
            }
            list.add(a[i]);
        }
        ret.add(list.get(0));
        for(; i< a.length;i++){
            if(a[i]>list.get(0)) list.clear();
            list.add(a[i]);
            ret.add(list.get(0));
        }
        return ret;
    }
}
