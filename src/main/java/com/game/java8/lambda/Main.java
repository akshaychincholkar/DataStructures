package com.game.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        System.out.println("***************JAVA 8********************");
        MathOperation addtion = (a, b)->{return a+b;};
        System.out.println("Lambda operation: addition:"+addtion.operation(1,2));

        Salutation greet = (name)-> System.out.println("Hi "+name+" !");
        greet.sayHi("Akshay");

    }
    interface MathOperation {
        int operation(int a, int b);
    }
    interface Salutation{
        void sayHi(String name);

    }




}
