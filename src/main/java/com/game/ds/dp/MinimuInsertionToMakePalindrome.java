package com.game.ds.dp;

public class MinimuInsertionToMakePalindrome {
    public static void main(String[] args) {
        String s = "agbcbfea"; //lcs : abcba
        int deletions = getMinimumInsertionToMakePalindrome(s);
        System.out.println("Length is :"+deletions);
    }

    public static int getMinimumInsertionToMakePalindrome(String s) {
        return s.length()-
                LongestPalindromicSubsequence.
                        getLongestPalindromicSubsequence(s);
    }
}
