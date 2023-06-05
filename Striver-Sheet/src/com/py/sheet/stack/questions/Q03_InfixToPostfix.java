package com.py.sheet.stack.questions;

import java.util.*;

public class Q03_InfixToPostfix {
    public static void main(String args[]){
        String infixExp = "A*(B+C)/D" ;//"a+b*(c^d-e)^(f+g*h)-i";
        System.out.printf("infix expresession:: %s \n",infixExp);
        String postfixExp = infixToPostfix(infixExp);
        System.out.printf("\ncorresponding postfix:: %s",postfixExp);
    }
    public static 
    String infixToPostfix(String exp) {
        // Your code here
        Set<Character> operators =  new HashSet<>();
        Map<Character, Integer> prec = new HashMap<>();
        prec.put('^',1);
        prec.put('*',2);
        prec.put('/',2);
        prec.put('+',3);
        prec.put('-',3);
        prec.put('(',99);
        operators.addAll(Arrays.asList('^','+','-','/','*','(',')'));
        int strLen =  exp.length();
        StringBuilder postfix = new StringBuilder(strLen);
        Stack<Character> st = new Stack<>();
        // string scanning left to right
        for(int i=0; i<strLen ; i++){
            char ch = exp.charAt(i);
            if(!operators.contains(ch)){
                // System.out.printf(" %c",ch);
                postfix.append(ch);
            }else if(ch == '('){
                st.push(ch);
            }else if(ch==')'){
                char cht;
                while(!st.isEmpty() && ('(' != (cht=st.pop()))){
                    // System.out.printf(" %c",cht);
                    postfix.append(cht);
                }
            }else{
                // character is an operator
                    while(!st.isEmpty() && (prec.get(ch)>= prec.get(st.peek()))){
                        postfix.append(st.pop());
                        // System.out.printf(" %c",st.pop());
                    }
                    st.push(ch);
                }

            }
        while(!st.isEmpty()){
            char ch = st.pop();
            if(ch!='(' || ch!= ')'){
                // System.out.printf(" %c",ch);
                postfix.append(ch);
            }
        }
        return postfix.toString();
    }
}
