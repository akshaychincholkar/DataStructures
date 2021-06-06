package com.game.ds.dp;

public class SubsetSum {
    public static void main(String[] args) {
        int[] a = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        boolean sumFound = isSubsetFound(a,sum);
        System.out.println("subset found: "+sumFound);
    }

    public static boolean isSubsetFound(int[] a, int sum) {
        boolean[][] result = new boolean[a.length+1][sum+1];
        // If sum is 0, then answer is true
        for (int i = 0; i <= a.length; i++)
            result[i][0] = true;

        // If sum is not 0 and set is empty,
        // then answer is false
        for (int i = 1; i <= sum; i++)
            result[0][i] = false;

        for(int i=1;i<=a.length;i++){
            for(int j=1;j<=sum;j++){

                if(a[i-1]<=j){
                    result[i][j] = result[i-1][j-a[i-1]] || result[i-1][j];
                }else{
                    result[i][j] = result[i-1][j];
                }
                System.out.print(result[i][j]+"\t");
            }
            System.out.println();
        }
        return result[a.length][sum];
    }
}
