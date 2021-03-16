package com.game.ds.arrays;

public class FrequencyOfArrayElements {
    public static void main(String[] args) {
        int[] a = {2, 3, 2, 4, 5};
        int i = 1;
        calculateCount(a);
        for (int element : a) {
            System.out.println(i + " has count:" + Math.abs(element));
            i++;
        }
    }

    private static void calculateCount(int[] a) {
        int i = 1;
        while (i <= a.length) {
            if (a[i - 1] < 0) {
                i++;
                continue;
            } else if (a[i - 1] == i) {
                a[i - 1] = -1;
                i++;
            } else if (a[i - 1] > 0) {
                if (a[a[i - 1] - 1] < 0) {
                    a[a[i - 1] - 1] -= 1;
                    a[i - 1] = 0;
                    i++;
                } else {
                    int temp = a[a[i - 1] - 1];
                    a[a[i - 1] - 1] = -1;
                    a[i - 1] = temp;
                }
            }
        }
    }
}
