package main.codility;

import java.util.Stack;

public class Fish {
    public static void main(String[] args) {

        System.out.println(new Fish().solution(new int[]{4,3,2,1,5},new int[]{0,1,0,0,0}));

    }

     public int solution(int[] A, int[] B){

         Stack<pair> stack = new Stack<>();

         for(int i = 0;i<B.length;i++){

             if(B[i] == 0){
                 while (!stack.isEmpty() && stack.peek().d == 1 && stack.peek().w < A[i]){
                      stack.pop();
                 }
                 if(!stack.isEmpty() && stack.peek().d == 1 && stack.peek().w > A[i] ){
                     //dont push
                 }else {
                     stack.push(new pair(B[i],A[i]));
                 }
             }else {
                 stack.push(new pair(B[i],A[i]));
             }

         }
        return stack.size();
     }
     class pair{
        int d;
        int w;

         public pair(int d, int w) {
             this.d = d;
             this.w = w;
         }
     }

}
