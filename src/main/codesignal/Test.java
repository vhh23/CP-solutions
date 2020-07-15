package main.codesignal;

import java.util.*;

public class Test {

    public static void main(String[] args) {
       /* System.out.println(new Test().meanGroups(new int[][]{
                {-2,4,7,-6,2,-5,3},
        {-1,0,0,0},
        {2,2,-6,17,9,-22,30,-16,0,-1,-11,6,0,-4},
        {3,3,-8,-2,3}

        }));*/
        System.out.println(new Test().wordCount(new char[][]{
                {'s','o','s','o'},
                {'s','o','o','s'},
                {'s','s','s','s'},
                },
                "sos"));
    }

    int[][] meanGroups(int[][] a) {

        int n = a.length;

        Map<Double, TreeSet<Integer>> map = new HashMap<>();

        for(int i = 0;i<n;i++){
            double avg = 0;
            int l = a[i].length;
            for(int j = 0;j<l;j++){
                avg += a[i][j];
            }
            avg = avg/l;
            if(map.containsKey(avg)){
                map.get(avg).add(i);
            }else{
                TreeSet<Integer> set = new TreeSet<>();
                set.add(i);
                map.put(avg, set);
            }
        }

        int[][] res = new int[n][];

        for(TreeSet<Integer> x:map.values()){

            int i = 0;
            res[x.first()] = new int[x.size()];
            for (Integer t : x) {
                res[x.first()][i] = t;
                i++;
            }
        }

        int[][] f = new int[map.values().size()][];
        int j = 0;;
        for(int[] x: res){
            if(x!= null){
                f[j] = new int[x.length];
                for(int i = 0;i<x.length;i++){
                    f[j][i] = x[i];
                }
                j++;
            }


        }

    return res;

    }
    int absoluteValuesSumMinimization(int[] a) {

        double avg = 0;
        for(int i = 0;i<a.length;i++){
            avg+=a[i];
        }
        avg = avg/a.length;

        double min = Integer.MAX_VALUE;
        int minValue = Integer.MAX_VALUE;

        for(int i = 0;i<a.length;i++){
            if(Math.abs(a[i] - avg) < min){
                min = Math.abs(a[i] - avg);
                minValue = a[i];
            }
        }

        return minValue;

    }
    int absoluteValuesSumMinimization2(int[] a) {


        int minValue = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<a.length;i++){
            int value = 0;
            for(int j = 0;j<a.length;j++){
                value = value + Math.abs(a[j]-a[i]);
            }
            if(value < minValue){
                minValue = value;
                min = a[i];
            }
        }

        return min;

    }


    int wordCount(char[][] board, String word) {

        int n = board.length;
        int m = board[0].length;
        int res = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){

                res += count(board,word,i,j,n,m);
            }
        }
        return res;

    }

    int count(char[][] board, String word, int i , int j , int n, int m){
        int res = 0;
        //hori
        int k = 0;
        int x=i;
        int y = j;
        while( x<n && y <m && k<word.length() && board[x][y] == word.charAt(k)){
            y++;
            k++;
        }
        if(k == word.length()){
            res++;
        }

        //verticle
         k = 0;
         x=i;
         y = j;
        while(x<n && y <m && k<word.length() && board[x][y] == word.charAt(k)){
            x++;
            k++;
        }
        if(k == word.length()){
            res++;
        }
        //dia
        k = 0;
        x=i;
        y = j;
        while( x<n && y <m && k<word.length() && board[x][y] == word.charAt(k)){
            x++;
            y++;
            k++;
        }
        if(k == word.length()){
            res++;
        }

        return res;
    }




}
