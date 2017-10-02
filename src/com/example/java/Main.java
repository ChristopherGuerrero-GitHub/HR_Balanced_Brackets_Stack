package com.example.java;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        /*
            This program is a solution to HackerRank problem Balanced Bracket Stacks.

            Two brackets are considered to be a matched pair if the an opening bracket
            (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or })
            of the exact same type. There are three types of matched pairs of
            brackets: [], {}, and ().

            A matching pair of brackets is not balanced if the set of brackets it encloses
            are not matched. For example, {[(])} is not balanced because the contents in
            between { and } are not balanced. The pair of square brackets encloses a single,
            unbalanced opening bracket, (, and the pair of parentheses encloses a single,
            unbalanced closing square bracket, ].

            Given n strings of brackets, determine whether each sequence of brackets is balanced.
            If a string is balanced, print YES on a new line; otherwise, print NO on a new line.
         */

/*
        Input:
        3
        {[()]}
        {[(])}
        {{[[(())]]}}

        Output: YES NO YES
*/

        //get input from console and define variables
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        //get input string and invoke the isBalance method with the string variable
        // as the argument. Print out the results.
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            String result = isBalanced(s);
            System.out.println(result);
        }
        in.close();

    }

    /*
        This method isBalanced with a loop will push into a Stack all the characters
         that are open brackets ie. ([{ and then when a close bracket occurs that
         matches one of the following types )]} it will pop the corresponding open
         bracket. If all the brackets in the stack are matched and popped the return
         string will be Yes else it will be No.
     */
    static String isBalanced(String s){

        Stack<Character> charStack = new Stack<Character>();
        char charData;

        for(int i = 0; i < s.length(); i++){
            charData = s.charAt(i);

            if(charData == ')'){
                if(!charStack.isEmpty() && charStack.peek() == '('){
                    charStack.pop();

                }else{
                    return "NO";
                }

            }else if(charData == '}'){
                if(!charStack.isEmpty() && charStack.peek() == '{'){
                    charStack.pop();

                }else{
                    return "NO";
                }

            }else if(charData == ']'){
                if(!charStack.isEmpty() && charStack.peek() == '['){
                    charStack.pop();

                }else{
                    return "NO";
                }

            }else{
                charStack.push(charData);
            }

        }
        if(!charStack.isEmpty()){
            return "NO";
        }else{
            return "YES";
        }

    }
}
