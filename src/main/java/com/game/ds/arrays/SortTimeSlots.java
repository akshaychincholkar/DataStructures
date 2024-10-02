package com.game.ds.arrays;

// "We are working on a security system for a badged-access room in our company's
// building.

// We want to find employees who badged into our secured room unusually often.
// We have an unordered list of names and entry times over a single day.
// Access times are given as numbers up to four digits in length using 24-hour time,
// such as ""800"" or ""2250"".

// Write a function that finds anyone who badged into the room three or more times
// in a one-hour period. Your function should return each of the employees who fit
// that criteria, plus the times that they badged in during the one-hour period.
// If there are multiple one-hour periods where this was true for an employee,
// just return the earliest one for that employee.

// badge_times = [
// [""Paul"", ""1355""],
// [""Jennifer"", ""1910""],
// [""John"", ""835""],
// [""John"", ""830""],
// [""Paul"", ""1315""],
// [""John"", ""1615""],
// [""John"", ""1640""],
// [""Paul"", ""1405""],
// [""John"", ""855""],
// [""John"", ""930""],
// [""John"", ""915""],
// [""John"", ""730""],
// [""John"", ""940""],
// [""Jennifer"", ""1335""],
// [""Jennifer"", ""730""],
// [""John"", ""1630""],
// [""Jennifer"", ""5""]
// ]

// Expected output (in any order)
// John: 830 835 855 915 930
// Paul: 1315 1355 1405"

import java.util.*;

public class SortTimeSlots {
    public static void main(String[] args) {
        String[][] badge_times = {
                {"Paul", "1355"},
                {"Jennifer", "1910"},
                {"John", "835"},
                {"John", "830"},
                {"Paul", "1315"},
                {"John", "1615"},
                {"John", "1640"},
                {"Paul", "1405"},
                {"John", "855"},
                {"John", "930"},
                {"John", "915"},
                {"John", "730"},
                {"John", "940"},
                {"Jennifer", "1335"},
                {"Jennifer", "730"},
                {"John", "1630"},
                {"Jennifer", "5"}
        };
        Map<String, List<Time>> result = processBatches(badge_times);
        System.out.println(result);
    }

    private static Map<String, List<Time>> processBatches(String[][] badgeTimes) {
        Map<String,List<Time>> map = new HashMap<>();
        for(int i=0;i<badgeTimes.length;i++){
            String key =badgeTimes[i][0];
            Integer startTime = Integer.parseInt(badgeTimes[i][1]);
            Integer endTime = processEndTime(startTime);
            List<Time> values = new ArrayList<>();
            if(map.containsKey(key)){
                values = map.get(key);
                values.add(new Time(startTime,1));
                map.put(key,values);
            }else{
                values.add(new Time(startTime,1));
                map.put(key,values);
            }
            values.add(new Time(endTime,-1));
            map.put(key,values);
        }
        for (String name:map.keySet()){
            List<Time> list = map.get(name);
            Collections.sort(list,(Time a,Time b)->{return a.getTime()-b.getTime();});
            map.put(name,list);
        }
        Map<String,List<Time>> returnMap = new HashMap<>();
        for(Map.Entry<String, List<Time>> entry:map.entrySet()){
            List<Time> list = entry.getValue();
            // iterate and put into result if >= 3
            int count = 0;
            List<Time> returnList = new ArrayList<>();
            for(int i = 0;i<list.size();i++){
                count += list.get(i).getFlag();
                if(count >= 3 && returnList.size()<count){
                    if(count==3){
                        for(int j=i;j>=i-count+1;j--){
                            returnList.add(list.get(j));
                        }
                    }else returnList.add(list.get(i));
                }
//                else if(count>3) returnList.add(list.get(i));
            }
            returnList.sort(Collections.reverseOrder((Time t1,Time t2)->t1.getTime()-t2.getTime()));
            if(!returnList.isEmpty())returnMap.put(entry.getKey(),returnList);
        }
        return returnMap;
    }

    private static Integer processEndTime(Integer startTime) {
        return (startTime+100)>2400?(startTime+100)%2400:(startTime+100);
    }
}
class Time{
    private int time;
    private int flag;
    Time(int time,int flag){
        this.time = time;
        this.flag = flag;
    }

    public int getTime() {
        return time;
    }

    public int getFlag() {
        return flag;
    }

    @Override
    public String toString() {
        return " "+getTime()+" ";
    }
}
