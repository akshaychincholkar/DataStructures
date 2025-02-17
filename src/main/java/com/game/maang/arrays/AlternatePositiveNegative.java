package com.game.maang.arrays;

import java.util.ArrayList;

public class AlternatePositiveNegative {
    public static void main(String[] args) {
        int[] a={1, 2, 3, -4, -1, 4};
        setPositivesNegatives(a);
        for(int element:a) System.out.print(element+"\t");

        int[] b = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        setPositivesNegatives(b);
        System.out.println();
        for(int element:b) System.out.print(element+"\t");
    }

    public static void setPositivesNegatives(int[] a) {
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();

        for(int element:a)
            if(element>=0)positive.add(element);
            else {
                negative.add(element);
            }
        int i =0;
        for(; !positive.isEmpty() && !negative.isEmpty();i++){
            if(i%2==0)a[i]=positive.remove(0);
            else a[i] = negative.remove(0);
        }
        while(!positive.isEmpty()){
            a[i] = positive.remove(0);
            i++;
        }
        while(!negative.isEmpty()){
            a[i] = negative.remove(0);
            i++;
        }
    }
}
