package com.game.maang.arrays;

import java.util.*;

public class IntersectionOfArrays {
    public static void main(String[] args) {
        int[] a = {1, 2, 1, 3, 1};
        int b[] = {3, 1, 3, 4, 1};
        System.out.println(getIntersection(a,b));
    }

    public static Set<Integer> getIntersection(int[] a, int[] b) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for(int num:a)set.add(num);
        for(int element:set)
            if(set.contains(element))result.add(element);
        return result;
    }
}
