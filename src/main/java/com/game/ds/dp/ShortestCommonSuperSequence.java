package com.game.ds.dp;

public class ShortestCommonSuperSequence {
    public static void main(String[] args) {
//        String s1 = "AGGTAB";
//        String s2 = "GXTXAYB";
        String s1 = "acbcf";
        String s2 = "abcdaf";
        int count = getShortestCommonSuperSequence(s1,s2,s1.length(),s2.length());
        System.out.println("Shortest Common Super Sequence:"+count);
    }

    private static int getShortestCommonSuperSequence
            (String s1, String s2, int n, int m) {
        return m+n-LCS.getLCSCountTopDown(s1,s2,
                s1.length(),s2.length());
    }
}
