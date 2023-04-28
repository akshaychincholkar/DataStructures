package com.game.java8.lambda;

public class ParkingLot {

    public static void main(String[] args) {
        int hrs = 3;
        int mins = 14;
        System.out.println("Fare : "+calculateFare(hrs,mins,10,0));

        // stadium bike
//        int[] timeFrame = {1,4,12};
//        int[] fees = {30,60,100};

        // stadium car
//        int[] timeFrame = {1,4,12};
//        int[] fees = {60,120,200};
        //car
//        int[] timeFrame = {1,8,24};
//        int[] fees = {30,60,100};
        hrs = 13;
        mins = 5;

        // airport bike
        int[] timeFrame = {1,8,24};
        int[] fees = {40,60,80};

        // airport car
//        int[] timeFrame = {1,12,24};
//        int[] fees = {60,80,100};
        hrs = 14;
        mins = 59;
        System.out.println("Fare 2: "+calculateFare(hrs,mins,timeFrame,fees,0));
    }
    // 8 hours 15 mins
    public static int  calculateFare(int hrs, int mins,int[] timeframe, int[] fee, int fare){
        boolean isInRange = false;
        for(int i = timeframe.length-1;i>=0;i--){
            int calc= hrs/timeframe[i];
            if(calc > 0){
                if(i==timeframe.length-1) {
                    isInRange=true;
                    fare += (hrs%timeframe[i]) * fee[i];
                }
                if(!isInRange){
                    fare += fee[i];
                    hrs = hrs/timeframe[i];
                }
            }
            if(isInRange){
                fare += fee[i];
            }
            hrs = hrs % timeframe[i];
        }

        return fare;
    }
    public static int  calculateFare(int hrs,int mins, int fee, int fare){
        if(hrs == 0) {
            if(mins == 0)return fare;
            return calculateFare(hrs,0, fee,fare+fee);
        }
        return calculateFare(hrs-1,mins, fee,fare+fee);
    }




}
