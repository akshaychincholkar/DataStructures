package com.game.ds.dp;

public class MCM {
    static int t[][]=new int[1001][1001];
    public static void main(String[] args) {
        int[] a = {40, 20, 30, 10, 30};

        for(int i = 0;i<1001;i++){
            for(int j =0 ;j<1001;j++){
                t[i][j] = -1;
            }
        }
        int min = getMCMRecursive(a,1,a.length-1);
        System.out.println("MCM recursive: "+min);

        int min2 = getMCMMemoization(a,1,a.length-1);
        System.out.println("MCM memoization: "+min2);
    }

    public static int getMCMRecursive(int[] a, int i, int j) {
        if(i>=j){
            return 0;
        }
        int min =Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int temp = getMCMRecursive(a,i,k)+getMCMRecursive(a,k+1,j)+
                    a[i-1]*a[k]*a[j];
            if(temp<min)min = temp;
        }
        return min;
    }
    public static int getMCMMemoization(int[] a, int i, int j) {
        if(i>=j){
            return 0;
        }
        if(t[i][j] !=-1){
            return t[i][j];
        }
        int min =Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int temp = getMCMMemoization(a,i,k)+getMCMMemoization(a,k+1,j)+
                    a[i-1]*a[k]*a[j];
            if(temp<min)min = temp;
        }
        return t[i][j] = min;
    }
}
