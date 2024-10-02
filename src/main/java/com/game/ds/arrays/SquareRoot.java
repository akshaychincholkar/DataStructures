package com.game.ds.arrays;

public class SquareRoot {
    public static void main(String[] args) {
        System.out.println("Square root: "+getSquareRootWithPrecision(50,3));
    }

    private static double getSquareRootWithPrecision(int number, int precession) {
        int s = 0;
        int e = number;
        int mid = (s + e) / 2;
        while(s<e){
            int square = mid * mid;
            if(square == number) return mid;
            if(square < number) s = mid +1;
            else e = mid-1;
            mid = (s + e) / 2;
        }

        return findPrecession(s,number,precession);
    }

    private static float findPrecession(int root, int number, int precession) {
        double multiplier = 0.1;
        double newNo = root;
        for(int i = 1;i<=precession;i++){
            while(newNo * newNo <= number){
                newNo += multiplier;
            }
            newNo -= multiplier;
            multiplier = multiplier/10;
        }
        return (float) newNo;
    }
}
