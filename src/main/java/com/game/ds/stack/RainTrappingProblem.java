package com.game.ds.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class RainTrappingProblem {
    public static void main(String[] args) {
        int[] a={4,2,0,3,2,5};
        int traps = getRainTrappedSlots(a);
        System.out.println("Rain is trapped in "+traps+" slots");
    }

    private static int getRainTrappedSlots(int[] a) {
        int rainTrapped = 0;
        int[] mxl = new int[a.length];
        int[] mxr = new int[a.length];

        mxl[0]=a[0];
        for(int i=1;i<a.length;i++)
            mxl[i]=Math.max(mxl[i-1],a[i]);

        mxr[a.length-1]=a[a.length-1];
        for(int i=a.length-2;i>=0;i--)mxr[i]=Math.max(mxr[i+1],a[i]);

        int[] water = new int[a.length];
        for(int i=0;i<a.length;i++)rainTrapped += Math.min(mxl[i],mxr[i]) - a[i];

        return rainTrapped;
    }
}
