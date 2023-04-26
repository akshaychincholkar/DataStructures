package com.game.ds.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StoneBreak {
    public static void main(String[] args) {
        int[] a = {2,7,4,1,8,1};
        System.out.println("Last stone: "+lastStoneWeight(a));
    }
    public static int lastStoneWeight(int[] stones) {
        List<Integer> list = Arrays.stream(stones).boxed().collect(Collectors.toList());
        while(list.size()>1){
            Collections.sort(list, Collections.reverseOrder());
            System.out.println(list);
            int n1 =list.get(0);
            int n2 = list.get(1);
            // Calculate difference
            int diff = Math.abs(n1-n2);
            list.remove(0);
            list.remove(0);
            if(!(diff == 0)) {
                list.add(diff);
            }
        }
        System.out.println(list);
        return (list.size() == 1)?list.get(0):0;
    }
}

