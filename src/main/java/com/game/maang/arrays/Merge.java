package com.game.maang.arrays;

class Merge{
    public static void main(String[] args){
        int[] a = {2,4,6,8,10};
        int[] b = {1,3,5,7,9};
        display(a);
        display(b);
        display(merge(a,b));
    }
    public static int[] merge(int[] a, int[] b){
        if(a.length == 0 ) return b;
        if(a.length == 0 ) return a;
            int[] c = new int[a.length + b.length];
            int i=0,j=0,k=0;
        while(j<a.length && k <a.length){
            if(a[j] < b[k]) {
                c[i] = a[j];
                j++;
            }
            else {
                c[i] = b[k];
                k++;
            }
            i++;
        }
        while(j<a.length){
            c[i] = a[j];
            i++;
            j++;
        }
        while(k<b.length){
            c[i] = b[k];
            k++;
            i++;
        }
        return c;
    }
    public static void display(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+"  |");
        }
        System.out.println();
    }
}
