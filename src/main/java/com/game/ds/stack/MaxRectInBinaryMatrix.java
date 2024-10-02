package com.game.ds.stack;

public class MaxRectInBinaryMatrix {
    public static void main(String[] args) {
        int[][] a = {{0,1,1,0},
                {1,1,1,1},
                {1,1,1,1},
                {1,1,0,0}};
        int maxArea = getMaxSizeRectangle(a);
        System.out.println("Maximum rectangle area: "+maxArea);
    }

    public static int getMaxSizeRectangle(int[][] a) {
        int[] building = new int[a[0].length];
        int maxArea = 0;
        for(int i = 0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                System.out.print(a[i][j]+"\t");
                if(a[i][j] == 0) building[j] = 0;
                else building[j] += a[i][j];
            }
//            for(int element: building) System.out.print(element+"\t");
            int area = MaximumAreaInHistogram.getLargestRectagleArea(building);
            System.out.println("----------Maximum area:"+area);
            if(maxArea<area)maxArea = area;
            System.out.println();
        }
    return maxArea;
    }
}
