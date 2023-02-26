package com.py.sheet.linkedList.hard;

public class Node { 
    public int data; 
    public Node next; 

    Node() { 
    	data = 0; 
    }
    public Node(int d) {
    	data = d;
    }  //constructor to create a new node
    
    @Override
    public String toString() {
    	return this.data+ "->"+this.next;
    }
} 
