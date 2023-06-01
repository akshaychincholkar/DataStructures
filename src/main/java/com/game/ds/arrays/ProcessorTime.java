package com.game.ds.arrays;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ProcessorTime {
    public static void main(String[] args) {
//        int[]  a = {4,2,7,6,1};
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(2);
        list.add(7);
        list.add(6);
        list.add(1);

        int x = 4,y = 2;
        int operations = getMinimumOperations(list,x,y);
        System.out.println("Operations: "+operations);
    }

    private static int getMinimumOperations(List<Integer> list, int x, int y) {
        Iterator<Integer> iterator = list.iterator();
        int max = 0;
        for(Integer ele:list) max = Math.max(max,ele);
        System.out.println("Max:"+max);

/*        int i = 0;
        for(Integer element:list) {
            element+=1;
            list.set(i++,++element);
        }*/
        System.out.println(list);
//        List<Integer> nums = new CopyOnWriteArrayList<>(list);
        boolean doContinue = true;
        boolean isFirst = true;
        int operations = 0;

        int newMax = 0;
        while(doContinue){
            doContinue = false;
            if(isFirst){
                isFirst = false;
            }else{
                max = newMax;
            }
            for(int i = 0 ;i<list.size();i++){
                if(list.get(i) <= 0)continue;
                if(list.get(i)  == max){
                    list.set(i,list.get(i) -x);
                }else{
                    list.set(i,list.get(i) -y);
                }
                newMax = Math.max(newMax,list.get(i) );
                System.out.println(list+": "+list.get(i) );
                doContinue = true;
            }
            operations++;
            System.out.println("---------------------");
        }
        return operations;
    }
}
