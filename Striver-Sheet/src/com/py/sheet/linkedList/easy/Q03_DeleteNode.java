package com.py.sheet.linkedList.easy;

public class Q03_DeleteNode {
	
	static
	Node deleteNode(Node head, int x){
	    // Your code here	
		if(x<=0 || head ==null) {
			return head;
		}

		if(head.next ==null) {
	    	if(x==1)
	    		return head.next;
	    	else {
	    		System.err.println("IndexPassed is out of Bound");
	    		return head;
	    	}
	    }
	    	
	    if(x==1)
	        return head.next;
	    Node temp = head;
	    x--;
	    while(temp.next!=null && x>1){
	        temp=temp.next;
	        x--;
	    }
	    if(temp.next == null && x>=1) {
	    	System.err.printf("Index passed is out of bound\n");
	    	return head;
	    }
	    Node targetNode = temp.next;
	    temp.next = targetNode.next;
	    targetNode = null;
	    return head;
    }
	
	
	public static void main(String[] args) {
		int arr[] = {1,2};//{1,2,3,4,};
		int x=4;
		Node head =constructLL(arr);
		System.out.println(deleteNode(head, x));
	}
	
	static Node constructLL(int arr[]) {
        // code here
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
