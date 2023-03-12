package com.game.ds;

import java.util.*;

public class Test {
        public static void main(String[] args) {
            String x ="abc";
            String y = "abc";
            x.concat(y);
            System.out.println(x);
        }
    }
/*public class Test {
    public static void main(String[] args){
        int[] wt = {1,3,4,5};
        int[] val = {1,4,5,7};
        int n = 4;
        int w = 7;
        int profit = knapsack_0_1(wt,val,w,n);
        System.out.println("Profit 01: "+profit);
    }
    public static int knapsack_0_1(int[] wt,int[] val,int w, int n){
        if(n==0 || w==0) return 0;
        if(wt[n-1] <= w){
            return Math.max(val[n-1] + knapsack_0_1(wt,val,w-wt[n-1],n-1),knapsack_0_1(wt,val,w,n-1));
        }else {
            return knapsack_0_1(wt,val,w,n-1);
        }
    }*/
/*    public static void main(String[] args){
        String s = "aabacbebebe";
        int k = 3;
        System.out.println("Longest Unique characters Substring is in "+s+" is "+getLongestUniqueCharactersSubstringLength(s,k));
    }
    public static int getLongestUniqueCharactersSubstringLength(String s, int k){
        int i = 0, j = 0 , length = 0;;
        Map<Character,Integer> map = new HashMap<>();
        while(j<s.length()){
            Character c = s.charAt(j);
            if(map.containsKey(c)){
                map.put(c,map.get(c) +1);
            }else{
                map.put(c,1);
            }
            int curLen = j- i +1;
            if(length < curLen) length = curLen;
            if(map.size() > k){
                while(map.size() != k){
                    int updated = map.get(c)-1;
                    map.put(c,updated);
                    if(updated == 0) map.remove(c);
                    j++;
                }
            }else {j++;}
        }
        return length;
    }*/
//}
