package com.py.sheet.stack.learning;

import java.util.*;

public class L08_MinStackExtraSpace{

    static Stack<Integer> st;
    static Stack<Integer> sup_st;
    public static 
    void main(String...args){
        System.out.println("Min Stack using extra Space::");
        int arr[] = {18,19,29,16,15,17};
        int ops[] = {0,0,0,2,1,0,2,1,2,0,2,1,1,1,1,1,};;
        st = new Stack<>();
        sup_st = new Stack<>();
        minStackExtraSpace(arr,ops);
        System.out.println();
        System.out.println("Original stack ->> "+st);
        System.out.println("Min stack ->> " + sup_st);
        // System.out.println();
    }

    static
    void minStackExtraSpace(int elements[], int ops[]){
        int idx =0; 
        for(int op : ops){
            // idx ++;
            if(op == 0){ // push
                System.out.println("Pushing "+elements[idx]);
                push(elements[idx++]);     
            }
            else if(op == 1){ // pop
                System.out.println("---->popping "+ pop());
            }
            else{ // get min
                System.out.println("-*-*-*> min element yet "+ getMin());
            }
         }
    }
    /*returns min element from stack*/
    static int getMin(){
        // Your code here
        if(sup_st.isEmpty() ==  false)
            return sup_st.peek();
        return -1;
    }
    
    /*returns poped element from stack*/
    static int pop(){
        // Your code here
        int x=-1;
        if(st.isEmpty() == false)
            if((x=st.pop()) == sup_st.peek())
                sup_st.pop();	
        return x;
    }
    
    /*push element x into the stack*/
    static void push(int x){
        // Your code here	
        st.push(x);
        if(sup_st.isEmpty() || sup_st.peek()>x)
            sup_st.push(x);
    }
    
}