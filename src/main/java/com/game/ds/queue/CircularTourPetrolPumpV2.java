package com.game.ds.queue;

import java.util.ArrayList;
import java.util.List;

public class CircularTourPetrolPumpV2 {
        public static void main(String[] args){
/*
            int[] petrol = {4,6,7,4};
            int[] distance = {6,5,3,5};
*/
            int[] petrol = {4,1,1,1,1,15};
            int[] distance = {6,3,2,1,3,1};

            System.out.println("Start from: "+solve(petrol,distance));
        }
        public static int solve(int[] petrol, int[] distance){
            List<Journey> list = new ArrayList<>();
            for(int i = 0; i<petrol.length;i++) list.add(new Journey(petrol[i],distance[i]));

            int deficit = 0;
            int balance = 0;
            int start  = 0;
            for(int i = 0 ;i<list.size();i++){
                balance += list.get(i).getPetrol() - list.get(i).getDistance();
                if(balance <0){
                    deficit += balance;
                    start = (i+1)%list.size();
                    balance = 0;
                }
            }
            if(deficit + balance >=0) return start;
            else return -1;
        }
    }
    class Journey{
        private  int petrol;
        private int distance;
        Journey(int petrol,int distance){
            this.petrol = petrol;
            this.distance = distance;
        }
        int getPetrol(){return petrol;}
        int getDistance(){return distance;}
    }

