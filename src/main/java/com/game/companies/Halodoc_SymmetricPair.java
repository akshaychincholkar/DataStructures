package com.game.companies;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class Halodoc_SymmetricPair {
    public static void main(String[] args) {
        //1,3
        //2,17
        //3,1
        //45,76
        //8,9
        //17,2
        //1,8

//        ->1 ,2 ,3
        int[][] a= {{1,3},
                {2,17},
                {3, 1},
                {45,76},
                {8,9},
                {17,2}};
        printSymmetricPair(a);
    }

    private static void printSymmetricPair(int[][] a) {
        Map<Integer,Integer> map = new HashMap<>();
        System.out.println(a.length);

        for(int i=0;i<a.length;i++){
                map.put(a[i][0],a[i][1]);
        }
        //1,3
        for(int i=0;i<a.length;i++){
            if(map.containsKey(a[i][1])){
                System.out.println("Pair : {"+a[i][0]+","+a[i][1]+"} & "+" {"+map.get(a[i][1])+","+a[i][1]+"}");
            }
        }
//        for(Entry<Integer,Integer> entry:map.en)
    }
// n*2
}
