package com.game.ds.arrays;

import java.util.ArrayList;

public class WordInMatrix {
    public static void main(String args[]){
        char[][] grid = {
                {'c', 'c', 't', 'n', 'a', 'x'},
                {'c', 'c', 'a', 't', 'n', 't'},
                {'a', 'c', 'n', 'n', 't', 't'},
                {'t', 'n', 'i', 'i', 'p', 'p'},
                {'a', 'o', 'o', 'o', 'a', 'a'},
                {'s', 'a', 'a', 'a', 'o', 'o'},
                {'k', 'a', 'i', 'o', 'k', 'i'},
        };
        ArrayList<Coordinates> coordinates = getCoordinates(grid,"catnip");
        System.out.println("catnip: "+coordinates);
        ArrayList<Coordinates> coordinates1 = getCoordinates(grid,"cccc");
        System.out.println("cccc: "+coordinates1);
        ArrayList<Coordinates> coordinates3 = getCoordinates(grid,"aaoo");
        System.out.println("aaoo: "+coordinates3);
    }

    private static ArrayList<Coordinates> getCoordinates(char[][] grid, String word) {
        ArrayList<Coordinates> result = new ArrayList<>();
        // traverse matrix
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[i].length;j++){
                if(isValid(grid,i,j,word,result))return result;
                result.removeAll(result);
            }
        }
        return result;
    }

    private static boolean isValid(char[][] grid, int i, int j, String word, ArrayList<Coordinates> result) {
        if(word.length() == 0 )return true;
        if( i == grid.length || j == grid[i].length) return false;
        if(grid[i][j] == word.charAt(0)){
            result.add(new Coordinates(i,j));
            String t = word.substring(1);
            if(isValid(grid,i+1,j,t,result)) return true;
            if(isValid(grid,i,j+1,t,result)) return true;
            if(!result.isEmpty())result.remove(result.size()-1);
        }
        return false;
    }

}
class Coordinates{
    private int i;
    private int j;
    Coordinates(int i,int j){
        this.i = i;
        this.j = j;
    }
    public int getI(){return i;}
    public int getJ(){return j;}

    @Override
    public String toString() {
        return "("+i+","+j+")";
    }

}
