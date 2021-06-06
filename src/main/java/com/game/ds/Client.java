package com.game.ds;


import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        Producer producer = new Producer(producerConsumer);
        Consumer consumer = new Consumer(producerConsumer);

        Thread thread1 = new Thread(producer,"Thread -1");
        thread1.start();

        Thread thread2 = new Thread(consumer,"Thread -2");
        thread2.start();


//        thread1.join();
//        thread2.join();
    }

}
class Producer implements Runnable{
    ProducerConsumer producerConsumer;

    public Producer(ProducerConsumer producerConsumer) {
        this.producerConsumer = producerConsumer;
    }

    @Override
    public void run() {

        try {
            producerConsumer.produce();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable{
    ProducerConsumer producerConsumer;

    public Consumer(ProducerConsumer producerConsumer) {
        this.producerConsumer = producerConsumer;
    }

    @Override
    public void run() {
        try {
            producerConsumer.consume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ProducerConsumer {
    List<Integer> list = new ArrayList<Integer>();
    int MAX = 5;
    public void produce() throws InterruptedException {
        int number = 0;
        while(true){
            synchronized (this){
                while(list.size() == MAX){
                    wait();
                }
               list.add(++number);
                System.out.println("Producer produced : "+number);
                notify();
                Thread.sleep(1000);
            }
        }
    }
    public void consume() throws InterruptedException {
        while(true){
            synchronized (this){
                while(list.size() ==0){
                    wait();
                }
                System.out.println("Consumer consumed : "+list.remove(0));
                notify();
                Thread.sleep(1000);
            }
        }
    }
}