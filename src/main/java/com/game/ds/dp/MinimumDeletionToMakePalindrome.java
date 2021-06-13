package com.game.ds.dp;

public class MinimumDeletionToMakePalindrome {
    public static void main(String[] args) {
        String s = "agbcbfea"; //lcs : abcba
        int deletions = getMinimumDeletionToMakePalindrome(s);
        System.out.println("Length is :"+deletions);
    }

    public static int getMinimumDeletionToMakePalindrome(String s) {
        return s.length()-LongestPalindromicSubsequence.getLongestPalindromicSubsequence(s);
    }
}
