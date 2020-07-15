package main.codility;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NestedString {

    public static void main(String[] args) {

        System.out.println(isNestedString("}){}((){})"));
        System.out.println(isNestedString(""));
        System.out.println(isNestedString("({}){}((){)"));
        System.out.println(isNestedString("[[[{{(lkj)}}]]{(((kjh)))}]"));
        System.out.println(isNestedString("[bhj](){}"));
        System.out.println(isNestedString("({bhjk}){}("));


    }

    private static int isNestedString(String S) {

        if(S.isEmpty())
            return 1;

        Stack<Character> stack = new Stack<>();

         for(int i = 0;i<S.length();i++){
            if(S.charAt(i) == '(' || S.charAt(i) == '{' || S.charAt(i) == '['  ){
                stack.push(S.charAt(i));
            }else if(S.charAt(i) == ')' || S.charAt(i) == '}' || S.charAt(i) == ']' ){
                if(!stack.isEmpty()){
                    char pop = stack.pop();
                    if(S.charAt(i) == ')' && pop == '(')
                        continue;
                    else if(S.charAt(i) == '}' && pop == '{')
                        continue;
                    else if(S.charAt(i) == ']' && pop == '[')
                        continue;
                    else
                        return 0;
                }else
                    return 0;

            }
        }

        if(stack.isEmpty())
            return 1;
        else
            return 0;

    }

}
