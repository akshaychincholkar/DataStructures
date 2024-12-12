package com.game.maang.stacks;

public class MinStack {
    int top=0;
    int[] stack;

    MinStack(int capacity){
        stack = new int[capacity];
    }
    public int peek(){
        return isEmpty() ?-1:stack[top-1];
    }
    public boolean push(int value){
        if(isFull())return false;
        insert(value);
        top++;
        return true;
    }
    public void insert(int value){
        int i;
        for(i=top;i>0;i--){
            if(stack[i-1]>value) break;
            stack[i] = stack[i-1];
        }
        stack[i]=value;
    }
    public int pop(){
        return isEmpty() ?-1:stack[--top];
    }
    public void display(){
        for(int i=0;i<top;i++) System.out.print(stack[i]+"|");
        System.out.println();
    }
    public int getMin(){
        return stack[top-1];
    }
    public boolean isEmpty(){
        return top==0;
    }
    public boolean isFull(){
        return top==stack.length;
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack(3);
        stack.push(2);
        stack.push(12);
        stack.display();
        System.out.println("Smallest element is "+stack.peek());
        stack.push(10);
        stack.display();
        System.out.println("Smallest element is "+stack.peek());
    }
}
