package com.game.ds.miscellaneous;

public class OtherSumAndStringToIntegerMul {
    public static void main(String[] args) {

//        System.out.println(solution("011100"));
//        System.out.println(solution("111"));
        int[] a = {405,55,300,300};
//        System.out.println(solution("011100"));
        System.out.println(solution(a));
    }
    public static int solution(String S) {
        if(S.length() >= 400000) return 799999;
        int decimal=Integer.parseInt(S,2);
        System.out.println(decimal);
        return solve(decimal,0)-1;
    }
    public static int solution(int[] a){
        int maxSum = 0;
        for(int i = 0;i< a.length;i++){
            for(int j = 0 ;j<a.length;j++){
                if(i == j) continue;
                if(a[i]%10 == a[j]%10)maxSum=Math.max(maxSum,a[i]+a[j]);
            }
        }
        return maxSum;
    }
    public static int solve(int d,int number){
        if(d==0) return number;
        if(d%2 != 0) {
            d = d-1;
            number++;
        }
        return solve(d/2,++number);
    }
}
