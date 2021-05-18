package com.game.ds.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class OccuranceCountOfAnagrams {
    public static void main(String[] args) {
        String string = "aabaabaa";
        String pattern = "aaba";
        int count = getAnagramsCount(string,pattern);
        System.out.println("Anagram count :"+count);
    }

    private static int getAnagramsCount(String string,String pattern) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            if(map.containsKey(pattern.charAt(i))){
                map.put(pattern.charAt(i),map.get(pattern.charAt(i))+1);
            }else map.put(pattern.charAt(i),1);
        }
        int i;
        int slideCount = map.size();
        int anagramCount = 0;
        for(i = 0;i<pattern.length();i++){
            if(map.containsKey(string.charAt(i))){
                map.put(string.charAt(i),map.get(string.charAt(i))-1);
                if(map.get(string.charAt(i)) ==0)slideCount--;
            }
        }
        if(slideCount == 0) anagramCount++;
        for(;i<string.length();i++){
            int startWindow = i - pattern.length();
            if(map.containsKey(string.charAt(startWindow))){
                map.put(string.charAt(startWindow),map.get(string.charAt(startWindow))+1);
                if(map.get(string.charAt(startWindow))!=0)slideCount++;
            }
            if(map.containsKey(string.charAt(i))){
                map.put(string.charAt(i),map.get(string.charAt(i))-1);
                if(map.get(string.charAt(i)) == 0)slideCount--;
            }
            if(slideCount == 0)anagramCount++;
        }
        return anagramCount;
    }
}
