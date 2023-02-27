package com.py.sheet.linkedList.hard;

import com.py.sheet.linkedList.easy.Node;

public class Q31_MergeTwoSortedLL {

	static class LL{
		Node head;
		LL(Node head){
			this.head = head;
		}
		
		@Override
		public String toString() {
			return "["+this.head+"]";
		}
	}
	//Function to merge two sorted linked list.
    static
    Node sortedMerge(Node head1, Node head2) {
     // This is a "method-only" submission. 
     // You only need to complete this method
    	Node h1 = new Node(-1);
    	h1.next= head1;
    	Node h2 = new Node(-2);
    	h2.next = head2;
    	LL mergedLL = new LL(h1);
    	LL fromLL = new LL(head2);
    	while(h1.next!=null && fromLL.head !=null) {
    		if(fromLL.head.data<h1.next.data) {
    			addAndRemove(mergedLL,fromLL,h1);
    			
    		}
    		h1 = h1.next;
//    		else {
//    			head1 = head1.next;
//    		}
    		
    	}
    	if(h1.next==null) {
    		System.exit(0);
    		System.out.println(h1);
    	}
    	if(h2.next !=null) {
    		h1.next=h2;
    	}
    	
    	return mergedLL.head.next;
   } 
	private static void addAndRemove(LL mergedLL, LL fromLL, Node toRef) {
		Node t = fromLL.head;
		fromLL.head=fromLL.head.next;
		t.next = toRef.next;
		toRef.next = t;
//		System.out.println(mergedLL);
	}
	public static void main(String[] args) {
		int arr1[] = {101,111};//{5,10,15,40};
		int arr2 [] = {2,3,20};
		Node head1= constructLL(arr1);
		Node head2 = constructLL(arr2);
		head1 = sortedMerge(head1, head2);
		System.out.println(head1);
//		System.out.println(head2);
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
