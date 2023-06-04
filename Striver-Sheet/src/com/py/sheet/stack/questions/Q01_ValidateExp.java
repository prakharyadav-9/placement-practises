package com.py.sheet.stack.questions;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.*;

public class Q01_ValidateExp {
    
    /*
     * using character iterator
     * i am using it to learn iterators
     */
    // static boolean ispar(String x){
    //     // add your code here
    //     Map<Character,Character> map = new HashMap<>();
    //     if(x.length()%2!=0){
    //         return false;
    //     }
    
    //     map.put('(',')');
    //     map.put('{','}');
    //     map.put('[',']');
    
    //     Stack<Character> stack = new Stack<>();
    //     CharacterIterator it = new StringCharacterIterator(x);
    //     while(it.current()!=CharacterIterator.DONE){
    //         char ch = it.current();
    //         if(ch == '('|| ch=='[' || ch == '{'){
    //             stack.push(ch);
    //         }
    //         if(!stack.isEmpty() && ( ch==')'|| ch==']'|| ch=='}')){
    //             if(ch!=map.get(stack.pop())){
    //                 return false;
    //             }
    //         }
    //         it.next();
    //     }
    //     return true;
    // }

    public static void main(String...args){
        String exp = "[]())(";//)"()";//"[()]{}{[()()()}}";
        System.out.printf("is valid:: %b",ispar(exp));
    }
    static boolean ispar(String x){
        // add your code here
        Map<Character,Character> map = new HashMap<>();
        int xLen = x.length();
        if(xLen%2!=0){
            return false;
        }
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');

        // Extension 
        Set<Character> closingSet = new HashSet<>(3);
        closingSet.addAll(Arrays.asList('}',')',']'));
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<xLen;i++){
            char ch = x.charAt(i);
            if(ch == '('|| ch=='[' || ch == '{'){
                stack.push(ch);
            }
            if(stack.isEmpty()==true && (closingSet.contains(ch))){
                return false;
            }
            if(!stack.isEmpty() && ( ch==')'|| ch==']'|| ch=='}')){
                if(ch!=map.get(stack.pop())){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
