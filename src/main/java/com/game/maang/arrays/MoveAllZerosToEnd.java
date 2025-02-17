package com.game.maang.arrays;

public class MoveAllZerosToEnd {
    public static void main(String[] args) {
        int a[]= {1, 2, 0, 4, 3, 0, 5, 0};
        move(a);
        for (int element:a) System.out.print(element+"\t");
    }
    public static void move(int[] a){
        int zero_count = a[0]==0?1:0;
        for(int i=1;i<a.length;i++){
            a[i-zero_count]=a[i];
            if(a[i]==0)zero_count++;
        }
        for(int i=a.length-zero_count;i<a.length;i++)a[i]=0;
    }
    static void pushZerosToEnd(int[] arr) {

        // Pointer to track the position for next non-zero element
        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            // If the current element is non-zero
            if (arr[i] != 0) {

                // Swap the current element with the 0 at index 'count'
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;

                // Move 'count' pointer to the next position
                count++;
            }
        }
    }
}
