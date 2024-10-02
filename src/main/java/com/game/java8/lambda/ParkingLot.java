package com.game.java8.lambda;

import java.util.Date;

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
//        hrs = 14;
//        mins = 59;

        // airport bike
        int[] timeFrame = {0,1,8,24};
        int[] fees = {0,40,60,80};

        // airport car
//        int[] timeFrame = {0,12,24};
//        int[] fees = {60,80,100};


        hrs = 36;
        mins = 12;
        System.out.println("Fare 2: "+calculateFareAirport(hrs,mins,timeFrame,fees,0));

        Date d1 = new Date("28-May-2022 8:01:00");
        Date d2 = new Date("31-May-2022 8:00:00");
        final int MILLI_TO_HOUR = 1000 * 60 * 60;
        final int MILLI_TO_MINS = 60 * 1000 ;
        int totalHours = (int) (d2.getTime() - d1.getTime()) / MILLI_TO_HOUR;
        int totalMins = (int) (d2.getTime() - d1.getTime()) / MILLI_TO_MINS % 60 ;
        System.out.println("Time difference: "+totalHours+" and "+totalMins+" mins");
    }
    public static int  calculateFareAirport(int hrs, int mins,int[] timeframe, int[] fee, int fare){
        for(int i = timeframe.length-2;i>=0;i--){
            if(hrs>=timeframe[i] && hrs<timeframe[i+1])return fee[i];
        }
        int calc = hrs/24;
        int result = 0;
        if(calc>=1){
            result = calc*fee[fee.length-1];
            if(hrs%24>=1) result+=fee[fee.length-1];
        }
        return result;
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
