package com.game.maang.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Duplicates{
    public static List getDuplicates(int[] a){
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int element: a){
            if(!set.add(element)){
                list.add(element);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,3,5,7,5,9};
        System.out.println(getDuplicates(a));
    }
}
