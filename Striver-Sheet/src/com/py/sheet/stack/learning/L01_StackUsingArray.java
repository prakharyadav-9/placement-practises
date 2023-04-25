package com.py.sheet.stack.learning;

import java.util.Arrays;

public class L01_StackUsingArray {
    
    /*
     * Implement a stack using an array
     */
    private static class stack{
        private int size;
        private int s [];
        int top ;
        stack(int size){
            this.size = size;
            s = new int[size];
            this.top = -1;
        }

        public void push(int ele){
            if(this.top<this.size){
                this.top++;
                s[top] = ele;
            }
            else{
                System.err.println("Stack is full.. cannot enter element");
            }
        }

        public int peek(){
            if(this.top  !=-1){
                return s[top];
            }
            return top;
        }

        public int pop(){
            if(this.top!=-1){
                return s[this.top--];
            }
            return this.top;
        }

        public int size(){
            return this.top+1;
        }

        public boolean isStackEmpty(){
            return this.top==-1?true:false;
        }

        public String toString(){
            if(this.isStackEmpty())
                return "[]";
            return Arrays.toString(s);
        }
    };
    public static void main(String...args){
        int size =5;
        stack s = new stack(size);
        System.out.println(s.isStackEmpty());
        s.push(7);
        s.pop();
        s.push(7);
        s.push(7);
        s.push(7);
        s.push(7);
        s.push(7);
        s.push(7);
        System.out.println(s);

    }
}
