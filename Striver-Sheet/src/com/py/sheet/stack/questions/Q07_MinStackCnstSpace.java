package com.py.sheet.stack.questions;

import java.util.*;

public class Q07_MinStackCnstSpace {
    
    public static void main(String...args){
        int arr[] = {18,19,29,16,15,17};
        int ops[] = {0,0,0,2,1,0,2,1,2,0,2,1,1,1,1,1,};;
        minStacCnstSpace(arr,ops);
    }

    private static void minStacCnstSpace(int[] arr, int[] ops) {
        int idx =0;
        GfG gfg = new GfG(); 
        for(int op : ops){
            // idx ++;
            if(op == 0){ // push
                System.out.println("Pushing "+arr[idx]);
                gfg.push(arr[idx++]);     
            }
            else if(op == 1){ // pop
                System.out.println("---->popping "+ gfg.pop());
            }
            else{ // get min
                System.out.println("-*-*-*> min element yet "+ gfg.getMin());
            }
         }
    }
}

class GfG
{
    int minEle;
    Stack<Integer> s;
    
    // Constructor    
    GfG(){
        this.s = new Stack<>();
        this.minEle = -1;
	}
	
    /*returns min element from stack*/
    int getMin(){
    	// Your code here
    	if(this.s.isEmpty())
        	return -1;
        return this.minEle;
    }
    
    /*returns poped element from stack*/
    int pop(){
    	// Your code here
    	if(this.s.isEmpty())   return -1;
    	int y = this.s.pop();
    	if(y<this.minEle){
    	    this.minEle = 2*this.minEle -y;   
    	}
        return y;
    }
    

    /*push element x into the stack*/
    void push(int x){
    	// Your code here	
    	if(this.s.isEmpty()){
    	    this.minEle = x;
    	    this.s.push(x);
    	    return ;
    	}
    	if(this.minEle>x){
    	    // new min element coming
    	    this.s.push(2*x-this.minEle);
    	    this.minEle = x;
    	}else{
        	 this.s.push(x);   
    	}
	
    }	
}
