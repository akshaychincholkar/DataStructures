package com.game.ds.dp;

public class CoinChangeProblem {

    public static void main(String[] args) {
        int[] a = {1,2,3};
        int sum = 5;
        int count = getCoinCombinations(a,sum,a.length);
        System.out.println("count :"+count);

    }

    private static int getCoinCombinations(int[] a, int sum, int length) {
        int[][] t = new int[length+1][sum+1];
        for (int i = 0; i <= a.length; i++)
            t[i][0] = 1;

        // If sum is not 0 and set is empty,
        // then answer is false
        for (int i = 1; i <= sum; i++)
            t[0][i] = 0;
        for(int i = 1;i<=a.length;i++){
            for(int j= 1;j<=sum;j++){
                if(a[i-1]<=j){
                    t[i][j]=t[i][j-a[i-1]]+t[i-1][j];
                }else{
                    t[i][j]=t[i-1][j];
                }
            }
        }
        for(int i =0;i<=a.length;i++){
            for(int j=0;j<=sum;j++){
                System.out.print(t[i][j]+"\t");
            }
            System.out.println();
        }
        return t[length][sum];
    }
}
