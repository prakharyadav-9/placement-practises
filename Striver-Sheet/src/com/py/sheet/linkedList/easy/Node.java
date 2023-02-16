package com.py.sheet.linkedList.easy;

class Node { 
    int data; 
    Node next; 

    Node() { 
    	data = 0; 
    }
    Node(int d) {
    	data = d;
    }  //constructor to create a new node
    
    @Override
    public String toString() {
    	return this.data+ "->"+this.next;
    }
} 
