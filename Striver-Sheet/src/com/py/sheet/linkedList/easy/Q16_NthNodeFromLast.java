package com.py.sheet.linkedList.easy;

public class Q16_NthNodeFromLast {

	static
	//Function to find the data of nth node from the end of a linked list.
    int getNthFromLast(Node head, int n){
    	// Your code here	
    	Node slow=head;
    	Node fast = head;
    	
    	while(fast!=null){
    	    if(n>0){
    	    	// initially running only the fast pointer
    	        n--;
    	    }else{
    	    	// when we have enough n node then move slow pointer
    	        slow=slow.next;
    	    }
    	    fast = fast.next; 
    	}
    	if(n>0)
    	    return -1;
	    return slow.data;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4,5,6,7,8,9};//{2};//
		Node head = constructLL(arr);
		int n=3;
		System.out.println(getNthFromLast(head, n));
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
