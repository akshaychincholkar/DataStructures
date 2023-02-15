package com.game.ds;

import java.util.*;

public class Test {

    public static void main(String[] args){
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
    }
}
