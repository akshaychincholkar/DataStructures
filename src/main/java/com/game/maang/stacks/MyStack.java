package com.game.maang.stacks;

import com.game.maang.linkedlists.MyLinkedList;

public class MyStack {
    int top = 0;
    int[] stack;
    public MyStack(int size){
        stack = new int[size];
    }
    public boolean push(int data){
        if(top == stack.length){
            System.out.println("[OVERFLOW] Stack is full");
            return false;
        }
        stack[top] = data;
        top++;
        return true;
    }
    public int pop(){
        if(top == 0){
            System.out.println("[UNDERFLOW] Stack is empty");
            return -1;
        }
        return stack[--top];
    }
    public void display(){
        for(int i=0;i<top;i++){
            System.out.print("|"+stack[i]+"|");
        }
        System.out.println();
    }

    public int peek(){
        return stack[(top - 1)];
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack(5);
        stack.display();
        stack.push(5);
        stack.push(4);
        stack.push(1);
        stack.display();
        stack.push(3);
        stack.push(2);
        stack.display();
        System.out.println("Element at top : "+stack.peek());
        stack.pop();
        stack.display();
        System.out.println("Element at top : "+stack.peek());
    }
}
