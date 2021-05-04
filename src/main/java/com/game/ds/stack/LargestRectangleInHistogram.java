package com.game.ds.stack;

import java.util.Stack;

class ArrayEntity{
    private int value;
    private int index;

    public ArrayEntity(int value, int index) {
        this.value = value;
        this.index = index;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] a =  {6, 2, 5, 4, 5, 1, 6};
        for(int element:a)
            System.out.print(element+"\t");
        System.out.println();
        int area = getLargestRectagleArea(a);
        System.out.println("Maximum area of rectangle is "+area);
    }

    private static int getLargestRectagleArea(int[] a) {
        int maxArea = 0;
        Stack<ArrayEntity> stack1 = new Stack<>();
        int[] NSR = new int[a.length];
        int[] NSL = new int[a.length];
        int[] width = new int[a.length];

        //NSR index
        for(int i=a.length-1;i>=0;i--){
            if(stack1.isEmpty())NSR[i] = a.length;
            else if(stack1.peek().getValue()<a[i])NSR[i] = stack1.peek().getIndex();
            else if(stack1.peek().getValue()>=a[i]){
                while(!stack1.isEmpty() && stack1.peek().getValue()>=a[i])stack1.pop();
                if(stack1.isEmpty())NSR[i] = a.length;
                else NSR[i] = stack1.peek().getIndex();
            }
            stack1.push(new ArrayEntity(a[i],i));
        }
        //NSL index
        for(int i=0;i<a.length;i++){
            if(stack1.isEmpty())NSL[i] = -1;
            else if(stack1.peek().getValue()<a[i])NSL[i] = stack1.peek().getIndex();
            else if(stack1.peek().getValue()>=a[i]){
                while(!stack1.isEmpty() && stack1.peek().getValue()>=a[i])stack1.pop();
                if(stack1.isEmpty())NSL[i] = a.length;
                else NSL[i] = stack1.peek().getIndex();
            }
            stack1.push(new ArrayEntity(a[i],i));
        }
        //width
        for(int i=0;i<a.length;i++){
            width[i] = NSR[i] - NSL[i] -1;
            if(maxArea<width[i] * a[i])maxArea = width[i]*a[i];
        }

        return maxArea;
    }
}
