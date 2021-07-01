package com.game.ds;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        PC pc = new PC();
        Thread thread1 = new Thread(new Producer_(pc));
        Thread thread2 = new Thread(new Consumer_(pc));

        thread1.start();
        thread2.start();
    }
}
class PC{
    List<Integer> list = new ArrayList<>();
    final int MAX= 5;
    Random random = new Random();
    public void produce() throws InterruptedException {
        while(true){
            synchronized (this){
                if(list.size()==MAX){
                    wait();
                }
                int number = random.nextInt(100);
                System.out.println("Added: "+number);
                list.add(number);
                notify();
                Thread.sleep(1000);
            }
        }
    }
    public void consume() throws InterruptedException {
        while(true){
            synchronized (this){
                if(list.size()==0){
                    wait();
                }
                System.out.println("Removed:"+list.remove(0));
                notify();
                Thread.sleep(1000);
            }
        }
    }
}
class Producer_ implements Runnable{
    PC pc;
    Producer_(PC pc){
        this.pc = pc;
    }
    @Override
    public void run() {
        try {
            pc.produce();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
class Consumer_ implements Runnable{
    PC pc;
    Consumer_(PC pc){
        this.pc = pc;
    }
    @Override
    public void run() {
        try {
            pc.consume();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}