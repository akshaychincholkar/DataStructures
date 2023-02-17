package com.game.ds.dp;

import java.util.ArrayList;
import java.util.List;

public class MinimumSubsetSumDifference {
    public static void main(String[] args) {
        int[] a = {5, 11, 6, 1};
        int minDifference = getMinSubsetSumDiff(a);
        System.out.println("Minimum difference: " + minDifference);

    }

    public static int getMinSubsetSumDiff(int[] a) {
        int range = 0;
        for (int element : a) range += element;
        int sum = (int) Math.floor(range / 2);

        //Subset sum code as it is
        boolean[][] result = new boolean[a.length + 1][sum + 1];
        // If sum is 0, then answer is true
        for (int i = 0; i <= a.length; i++)
            result[i][0] = true;

        // If sum is not 0 and set is empty,
        // then answer is false
        for (int i = 1; i <= sum; i++)
            result[0][i] = false;

        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= sum; j++) {

                if (a[i - 1] <= j) {
                    result[i][j] = result[i - 1][j - a[i - 1]] || result[i - 1][j];
                } else {
                    result[i][j] = result[i - 1][j];
                }
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();
        }
        List<Integer> temp = new ArrayList<Integer>();
        for (int i = 1; i <=sum ; i++) {
            if (result[a.length][i] ) temp.add(i);
        }
        //get last row
        int min =Integer.MAX_VALUE;
        for (int element : temp) {
            min = Math.min(min, range - 2 * element);
        }
        return min;
    }
}
