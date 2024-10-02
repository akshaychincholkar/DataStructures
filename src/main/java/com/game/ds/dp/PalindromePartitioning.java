package com.game.ds.dp;

import java.util.Arrays;

public class PalindromePartitioning {
    private static int t[][];
    public static void main(String[] args){
//        String s = "nitin";
        String s = "geeksforgeeks";
//        System.out.println(isPalindrome(s,0, s.length()));
        System.out.println("Recursion:"+getMinPalindromicPartitions(s,0,s.length()-1));
        System.out.println("Memoization: "+getMinPalindromicPartitionsMemoization(s,0,s.length()-1));
        System.out.println("Topdown: "+getMinPalindromicPartitionsTopdown(s,0,s.length()-1));
    }
    public static int getMinPalindromicPartitions(String s,int i, int j){
        if(i>=j || isPalindrome(s,i,j)) return 0;
        int min= Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int temp = 1 + getMinPalindromicPartitions(s,i,k)+getMinPalindromicPartitions(s,k+1,j);
            min = Math.min(min,temp);
        }
        return min;
    }

    public static int getMinPalindromicPartitionsMemoization(String s,int i, int j){
        t = new int[i+1][j+1];
        for(int[] array:t) Arrays.fill(array,-1);
        if(i>=j) return 0;
        if(isPalindrome(s,i,j))return 0;
        if(t[i][j]!=-1) return t[i][j];
        int min= Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int temp = 1 + getMinPalindromicPartitions(s,i,k)+getMinPalindromicPartitions(s,k+1,j);
            if(min>temp)min = temp;
        }
        return t[i][j] = min;
    }
    public static int getMinPalindromicPartitionsTopdown(String s,int i, int j){
        t = new int[s.length()+1][s.length()+1];
        for(int[] array:t) Arrays.fill(array,-1);
        if(i>=j) return 0;
        if(isPalindrome(s,i,j))return 0;
        if(t[i][j]!=-1) return t[i][j];
        int min= Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int left,right;
            if(t[i][k]!=-1) left = t[i][k];
            else left = getMinPalindromicPartitionsTopdown(s,i,k);

            if(t[k+1][j]!=-1)right = t[k+1][j];
            else right = getMinPalindromicPartitionsTopdown(s,k+1,j);

            int temp = 1 + left + right;
            min = Math.min(min,temp);
        }
        return t[i][j] = min;
    }
    static boolean isPalindrome(String string, int i, int j)
    {
        while(i < j)
        {
            if(string.charAt(i) != string.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
