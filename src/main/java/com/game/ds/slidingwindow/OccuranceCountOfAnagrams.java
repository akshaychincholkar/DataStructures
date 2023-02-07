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
    public static int getAnagrams(String a, String s){
        Map<Character,Integer> frequency = new HashMap<>();
        int anagrams = 0;
        for(int i=0; i<s.length(); i++){
            if(frequency.containsKey(s.charAt(i)))frequency.put(s.charAt(i),frequency.get(s.charAt(i))+1);
            else frequency.put(s.charAt(i),1);
        }
        int count = frequency.size();
        int i;
        for( i = 0; i< s.length();i++){
            char c = a.charAt(i);
            if(frequency.containsKey(c)){
                frequency.put(c,frequency.get(c)-1);
            }
            if(frequency.get(c) == 0) count--;
        }
        if(count == 0) anagrams++;
        for(;i< a.length();i++){
            int start = i - s.length();
            char c1 = a.charAt(start);
            char c2 = a.charAt(i);
            if(frequency.containsKey(c1)){
                frequency.put(c1,frequency.get(c1)+1);
                if(frequency.get(c1) !=0)count++;
            }
            if(frequency.containsKey(c2)){
                frequency.put(c2,frequency.get(c2)-1);
                if(frequency.get(c2) ==0) count--;
            }
            if(count == 0) anagrams++;
        }
        return anagrams;
    }
}
