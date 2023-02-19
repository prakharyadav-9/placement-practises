package com.py.sheet.linkedList.easy;

import java.util.HashSet;
import java.util.Set;

public class Q13_014_DetectLoopAndLength {

	/*
	 * Q013 - Detect loop
	 */
	//Function to check if the linked list has a loop.
    public static boolean detectLoop(Node head){
        // Add code here
    	/*
    	 * Approach 1 using set
    	 */
    	Set<Node>  nodes = new HashSet<>();
    	while(head!=null) {
    		if(!nodes.contains(head)) {
    			nodes.add(head);
    		}else {
    			return true;
    		}
    		head = head.next;
    	}
    	return false;
    }
    
    
	public static void main(String[] args) {
		int arr[] = {1,3,4};//{1,2,3,4,5};//{2};//
		Node head = constructLL(arr);
		int x=2;
		createLoop(head,x);
		System.out.printf("THe given LL contains loop? %b",detectLoop(head));
	}

	
	
	
	
	private static void createLoop(Node head,int x) {
		if(x==0 || head ==null)
			return;
		Node xthNode = head;
		Node t= head;
		while(t!=null) {
			x--;
			if(x==0) {
				xthNode = t;
			}
			head = t;
			t = t.next;
		}
		head.next = xthNode;
	}


	static Node constructLL(int arr[]) {
        // code here
		if(arr.length==0)
			return null;
		Node head = new Node(arr[0]);
		Node t=head;
		for(int i=1;i<arr.length;i++) {
			Node node = new Node(arr[i]);
			t.next=node;
			t=t.next;
		}
		return head;
    }
}
