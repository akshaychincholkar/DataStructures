package com.game.ds;

import java.util.ArrayList;
import java.util.List;

class Test{
    public static void main(String[] args){
        int[] a = {12,-1,-7,8,-15,30,18,28};
        List<Integer> negSubarray = getNegativeFirstSubarray(a,3);
        System.out.println(negSubarray);
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