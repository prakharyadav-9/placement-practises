package com.py.sheet.potd.gfg.Month02;

public class POTD_02_27 {

	static class Node{
	    int data;
	    Node next;

	    Node(int x){
	        data = x;
	    }
	    @Override 
	    public String toString() {
	    	return this.data+" "+this.next;
	    }
	}
	 public static Node reverse(Node head, int k) {
	        // code here
		 if(head == null || head.next==null)
			 return head;
		 Node curr= head, prevFirst=null;
		 int count=0;
		 Node prev= null;
		 Node next = null;
		 while(curr!=null) { //next = curr.next
			 next = curr.next;
			 curr.next = prev;
			 prev=curr;
			 curr=next;
			 count++;
			 if(count==k) {
				 prevFirst = prev;
				 prev=null;//curr;//head;
			 }
		 }
		 if(count<k)
			 return prev;
		 head.next = prev;
		 return prevFirst;
	    }
	 
	public static void main(String[] args) {
		int arr []  = {1,2};//{1,2,3,4,5,};
		Node head = constructLL(arr);
		int k=2;
		head  = reverse(head,k);
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
