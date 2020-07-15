package main.codility;

import java.util.Stack;

public class StoneWall {

    public static void main(String[] args) {

        System.out.println(new StoneWall().solution(new int[]{8,8,5,7,9,8,7,4,8}));
        System.out.println(new StoneWall().solution(new int[]{1,2,3,4,5,6,7,8}));
        System.out.println(new StoneWall().solution(new int[]{8,7,6,5,4,3,2,1}));
        System.out.println(new StoneWall().solution(new int[]{8,8,8,8,8}));
        System.out.println(new StoneWall().solution(new int[]{8,4,8,4,8,4,8}));
    }


    public int solution(int[] H){

        Stack<Integer> stack = new Stack<>();
        int counter = 0;
        for (int value : H) {

            while (!stack.isEmpty() && value < stack.peek())
                stack.pop();

            if (stack.isEmpty() || stack.peek() != value) {
                stack.push(value);
                counter++;
            }

        }
        return counter;
    }
}
