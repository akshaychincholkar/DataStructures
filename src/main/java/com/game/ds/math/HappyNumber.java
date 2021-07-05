package com.game.ds.math;

import java.util.HashSet;

public class HappyNumber {
    public static void main(String[] args){
        if(isHappy(19)) System.out.println("Number is happy number");
        else System.out.println("Number is not happy number");
    }
    public static boolean isHappy(int n) {
        HashSet<Integer> seen=new HashSet<>();

        while(n!=1){
            int sum=0;
            while(n!=0){
                sum+=(int)Math.pow((n%10),2);
                n=n/10;
            }

            if(seen.contains(sum))
                return false;

            seen.add(sum);
            n=sum;
        }
        return true;
    }
    public boolean myIsHappy(int n) {
        int no=n;
        HashSet<Integer> seen = new HashSet<Integer>();
        while(no!=1){
            no= getSquareSum(no);
            if(seen.contains(no))return false;
            seen.add(no);
        }
        return true;
    }
    public int getSquareSum(int n){
        String[] digits = String.valueOf(n).split("");
        int sum = 0;
        for(String digit:digits){
            // System.out.println(digit);
            int sqaure = Integer.parseInt(digit);
            // System.out.println(sqaure);
            sum += (int)Math.pow(sqaure,2);

            // System.out.println(sum);
        }
        return sum;
    }
}
