package com.py.sheet.queue.learning;

import java.util.Arrays;

public class L01_QueueUsingArray {
    
    private static class queue{
        int size;
        private int queue[];
        int front;
        int rare;
        
        queue(int size){
            this.size = size;
            this.front = -1;
            this.rare  = -1;
            this.queue = new int[size];
        }

        boolean add(Integer ele){
            if(this.rare+1 ==this.size){
                System.err.printf("The Queue is already full size= %d.. cannot insert :(",this.rare);
            }
            if (this.front ==-1){
                this.front++;
            }
            this.rare++;
            this.queue[this.rare] = ele;
            return true;
        }

        Integer peek(){
            if(this.front != -1)
                return this.queue[this.front];
            return null;
        }

        Integer remove(){
            Integer ele = null;
            if(this.front != -1){
                ele = this.queue[this.front];
                this.queue[this.front++] = 0;
                if(this.front == this.rare+1){
                    this.front = this.rare =-1;
                }
            }
            return ele;
        }

        public String toString(){
            return Arrays.toString(this.queue);
        }
    };

    public static void main(String...args){
        int size = 5;
        queue q1 = new queue(size);
        System.out.println(q1.toString());
        q1.add(7);
        System.out.println(q1.toString());
        q1.add(4);
        System.out.println(q1);
        System.out.printf("peek element :: %d\n",q1.peek());
        System.out.printf("Removed Element :: %d\n",q1.remove());
        System.out.printf("Queue:: %s\n",q1);
        System.out.printf("Removed Element :: %d\n",q1.remove());
        System.out.printf("Queue front:: %d, rare:: %d\n",q1.front, q1.rare);
        System.out.printf("Removed Element :: %d\n",q1.remove());
        System.out.printf("Queue front:: %d, rare:: %d | queue = %s\n",q1.front, q1.rare, q1);

    }
}
