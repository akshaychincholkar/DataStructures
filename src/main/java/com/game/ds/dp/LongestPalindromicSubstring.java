package com.game.ds.dp;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
//        String s = "agbcbfea"; //lcs : abcba
        String s = "babad"; //lcs : abcba
        List<String> list = new ArrayList<>();
        int length = getLongestPalindromicSubstring(s,list);
        System.out.println("Length is :"+length+" String: "+list.get(0));
    }

    public static int getLongestPalindromicSubstring(String s,List<String> list) {
        return LCSubString.getLCSubStringCountTopDownWithOutput(s,new StringBuilder(s).reverse()
                .toString(),s.length(),s.length(),list);
    }
}
