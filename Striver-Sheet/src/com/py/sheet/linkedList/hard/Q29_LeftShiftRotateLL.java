package com.py.sheet.linkedList.hard;

import com.py.sheet.linkedList.easy.Node;

public class Q29_LeftShiftRotateLL {

	//Function to rotate a linked list.
    static
    public Node rotate(Node head, int k) {
        // add code here
    	if(head ==null || head.next == null)
    		return head;
    	Node t = new Node(-1);//head;
    	t.next=head;
    	while(k!=0 ) {
    		t=t.next;
    		if(t.next==null)
    		    return head;
    		k--;
    	}
//    	System.out.println(t);
    	Node forward = t.next;
    	while(forward.next!=null) {
    		forward = forward.next;
    	}
    	forward.next=head;
    	head = t.next;
    	t.next = null;
    	return head;
    }
	public static void main(String[] args) {
		int arr[] = {2,20,21};//{1, 2, 3, 4, 5, 6, 7, 8};//{2, 4, 7, 8, 9};//{1,2,2,4,5,6,7,8,};//{1,2,3,4,5};//{2};//
		Node head=null;
		int k=1;
		head=constructLL(arr);
		head = rotate(head,k);
		System.out.println(head);

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
