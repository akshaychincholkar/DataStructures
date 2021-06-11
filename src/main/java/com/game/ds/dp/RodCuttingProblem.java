package com.game.ds.dp;

public class RodCuttingProblem {
    static int[][] t;
    public static void main(String[] args) {
//        int[] length = {1, 2, 3, 4, 5, 6, 7, 8};
//        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
//        int rod = 4;
//        int maxProfit = getMaxProfit(rod,length,price,length.length);
//        System.out.println("max profit:"+maxProfit);

        int[] length = {1, 2, 3};
        int rod = 5;
        System.out.println("Maximum profit: "+getCounts(rod,length,length.length));

    }

    public static int getMaxProfit(int rod,int[] length, int[] price,  int targetLen) {
            t = new int[targetLen+1][rod+1];
            for(int i = 1;i<=targetLen;i++){
                for(int j=1;j<=rod;j++){
                    if(length[i-1]<=j){
                        t[i][j] = Math.max(price[i-1] + t[i][j-length[i-1]],t[i-1][j]);
                    }else{
                        t[i][j] = t[i-1][j];
                    }
                }
            }
            return t[targetLen][rod];
    }
    public static int getCounts(int rod,int[] length,int targetLen) {
        t = new int[targetLen+1][rod+1];
        for (int i = 0; i <= length.length; i++)
            t[i][0] = 1;

        // If sum is not 0 and set is empty,
        // then answer is false
        for (int i = 1; i <= rod; i++)
            t[0][i] = 0;


        for(int i = 1;i<=targetLen;i++){
            for(int j=1;j<=rod;j++){
                if(length[i-1]<=j){
                    t[i][j]=t[i-1][j]+t[i][j-length[i-1]];
                }else{
                    t[i][j] = t[i-1][j];
                }
                System.out.print("\t"+t[i][j]);
            }
            System.out.println();
        }
        return t[targetLen][rod];
    }
}
