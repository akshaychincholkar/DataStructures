package com.game.ds.math;

public class GCD {
    public static void main(String[] args) {
        System.out.println("GCD of 4 and 6 is "+getGCD(4,6));
        System.out.println("GCD of 24 and 16 is "+getGCD(24,16));
        System.out.println("GCD of 24 and 16 by Euclidean is "+gcdByEuclidean(24,16));
    }
    public static int  getGCD(int a,int b){
        //    16 & 24
        int smaller = Math.min(a,b);
        int larger = Math.max(a,b);
        for(int i = smaller;i>=1;i--){
            if(smaller%i == 0 && larger%i==0){
                return i;
            }
        }
        return 1;
    }
//    Euclidean Algorithm
    public static int gcdByEuclidean(int a,int b){
        if(a==0) return b;
        if(b==0) return a;
        if(a>b) return gcdByEuclidean(a-b,b);
        return gcdByEuclidean(a,b-a);
    }
}
//Important information:
//Simplifying fractions
//The GCD is used to find the common denominator of fractions with different denominators. For example, to simplify a fraction, you can find the GCD of the numerator and denominator.
//Finding commonality
//The GCD can be used to find commonality in numbers. For example, 24=8 and 42=8, so either 2 four times or 4 two times can be used to get an eight.
//        Packing items
//The GCD can be used to pack items into boxes so that each set has the same number and takes up the least amount of space. For example, if a shopkeeper has 420 balls and 130 bats to pack, the GCD of 420 and 130 would be the number to place in each set.
//Splitting things into smaller sections
//The GCD can be used to figure out how many people to invite or to arrange something in rows or groups.
//        Cryptography
//The GCD is used in encryption algorithms like RSA.
//Determining the least common multiple (LCM)
//The GCD is used to determine the LCM of two or more numbers. The LCM is the smallest number that can be divided by all the numbers in a group.
// FYI: // lcm(a,b)= |ab| / gcd(a,b)
