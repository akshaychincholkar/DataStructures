package com.game.maang.arrays;

class VerifySorted {
    public static void display(int[] a) {
        for (int i = 0; i < a.length; i++) System.out.print(a[i] + " |");
        System.out.println();
    }

    public static boolean isSorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 5, 6, 7,10};
        System.out.println("Is array sorted: " + (isSorted(a) ? "Yes" : "No"));
        int[] b = {1, 4, 2, 9};
        System.out.println("Is array sorted: " + (isSorted(b) ? "Yes" : "No"));
    }
}
	
