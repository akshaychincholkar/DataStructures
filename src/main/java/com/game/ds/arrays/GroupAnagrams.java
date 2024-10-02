package com.game.ds.arrays;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] a = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = groupAnagrams(a);
        System.out.println(result);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();

        for(int i = 0 ;i<strs.length;i++){
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String t = new String(c);
            // System.out.println("t value:"+t);
            if(map.containsKey(t)){
                map.get(t).add(strs[i]);
            }else{
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(t,list);
            }
            // System.out.println(map);
        }
        for(Map.Entry entry: map.entrySet()){
            ret.add((List<String>)entry.getValue());
        }
        return ret;
    }
}

