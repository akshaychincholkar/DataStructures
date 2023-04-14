package com.game.ds.dp;

public class CoinChangeProblemMinCoins {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        int sum = 2;
        int minCoins = getMinCoins(a,sum);
        System.out.println("Miimum coins required: "+minCoins);
    }

    private static int getMinCoins(int[] a, int sum) {
        int[][] t = new int[a.length+1][sum+1];
        for (int i = 0; i <= a.length; i++)
            t[i][0] = 1;

        // If sum is not 0 and set is empty,
        // then answer is false
        for (int i = 0; i <= sum; i++)
            t[0][i] = Integer.MAX_VALUE-1;


        for (int j = 1; j <= sum; j++){
            if(j%a[0]==0)t[1][j] = j/a[0];
            else t[1][j] = t[0][j];
        }


        for(int i=2;i<=a.length;i++){
            for(int j=2;j<=sum;j++){
                if(a[i-1]<=j){
                    t[i][j]=Math.min(1+t[i][j-a[i-1]],t[i-1][j]);
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        for(int i=0;i<=a.length;i++){
            for(int j=0;j<=sum;j++){
                System.out.print("\t"+t[i][j]);
            }
            System.out.println();
        }
        return t[a.length][sum];
    }

}
