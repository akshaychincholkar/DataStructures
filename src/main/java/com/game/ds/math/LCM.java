package com.game.ds.math;

public class LCM {
    public static void main(String[] args) {
        System.out.println("LCM of the two values program");
        System.out.println("LCM of 8 * 12 is "+lcm(8,12));
    }
    public static int lcm(int a,int b){
        a = 8;
        b = 12;

        if(a%b == 0) return a;
        else if (b%a ==0 ) return b;
        int small = a<b?a:b;
        for(int i = 1;i<small;i++){
            if((small*i)%a == 0 && (small*i)%b == 0) return small*i;
        }
        return a*b;
    }

    // other logic

    // Function to return LCM of two numbers
    public static int findLCM(int a, int b)
    {
        int greater = Math.max(a, b);
        int smallest = Math.min(a, b);
        for (int i = greater;; i += greater) {
            if (i % smallest == 0)
                return i;
        }
    }
}
