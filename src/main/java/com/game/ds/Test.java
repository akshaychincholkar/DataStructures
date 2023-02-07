package com.game.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Test{
    public static void main(String[] args){
        int[] a = {1,3,-1,-3,5,3,6,7};
        List<Integer> list = getMaxSubArray(a,3);
        System.out.println(list);
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
