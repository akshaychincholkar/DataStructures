package com.game.companies;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        String s = "Ganesh";
        char[] c = s.toCharArray();
        System.out.println(c);
        Arrays.sort(c);
        HashMap<String, List<String>> map  = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("Test");
        map.put(c.toString(),list);
        List<List<String>> ret= new ArrayList<>();
        System.out.println(c);
        for(Map.Entry entry: map.entrySet()){
            ret.add((List<String>) entry.getValue());
        }
    }
}
