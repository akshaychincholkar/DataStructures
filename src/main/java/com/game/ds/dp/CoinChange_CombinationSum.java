package com.game.ds.dp;

import java.util.ArrayList;
import java.util.List;

public class CoinChange_CombinationSum {
    public static void main(String[] args) {
        int[] a = {2,3,5};
        int sum = 8;
        List<List<Integer>> result = combinationSum(a,sum);
        System.out.println(result);
    }
    public static List<List<Integer>> combinationSum(int[] a, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        getCandidates(ret,new ArrayList<>(),sum,0,a);
        return ret;
    }
    public static void getCandidates(List<List<Integer>> list, List<Integer> temp,int remain,int start,int[] a){
        if(remain < 0) return;
        if(remain == 0) list.add(new ArrayList(temp));
        else{
            for(int i = start;i<a.length;i++){
                temp.add(a[i]);
                getCandidates(list,temp,remain-a[i],i,a);
                temp.remove(temp.size()-1);
            }
        }
    }
}
