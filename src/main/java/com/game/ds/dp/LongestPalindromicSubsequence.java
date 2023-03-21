package com.game.ds.dp;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
//        String s = "agbcbfea"; //lcs : abcba
        String s = "forgeeksskeegfor"; //lcs : abcba
        int length = getLongestPalindromicSubsequence(s);
        System.out.println("Length is :"+length);
    }

    public static int getLongestPalindromicSubsequence(String s) {
        return LCS.getLCSCountTopDown(s,new StringBuilder(s).reverse()
                .toString(),s.length(),s.length());
    }
}
