package com.py.sheet.linkedList.easy;

public class Q14_CheckPalindrome {

	static
	int getMiddle(Node head){
        // Your code here.
        int count= 0;
        Node temp = head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        int mid = (count/2) +1;
        return mid;
	}
	
	static 
	Node getNthNode(Node head,int n) {
		if(head==null || n<=0)
			return head;
		n--;
		while(head!=null && n!=0) {
			head =  head.next;
			n--;
		}
		return head;
	}
	
	static
	Node reverseList(Node head){
        // code here
        if(head == null || head.next == null) // if no element or inly element
        	return head;
        Node curr =head;
        Node prev=null;
        Node next = head.next;
        while(curr.next!=null) {
        	next = curr.next;
        	curr.next=prev;
        	prev=curr;
        	curr=next;
        }
        curr.next = prev;
        return curr;
    }
	
	static //Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) {
        //Your code here
		int mid = getMiddle(head); // get the upper bound Mid of tht list
		Node midNode = getNthNode(head, mid); // gets the Nth Node form the list 
		Node rev= null;
		if(mid%2==0) {
			rev = reverseList(midNode); // reverse the list form this point an return new head
		}else {
			rev = reverseList(midNode.next);
		}
		while(head!=midNode && rev!=null) {
			if(rev.data != head.data)
				return false;
			rev= rev.next;
			head=head.next;
		}
		if(head.data != midNode.data)
			return false;
		return true;   
    }
	public static void main(String[] args) {
		int arr[]={1,2,9,9,2,1};//{1,2,9,9,2,1};
		Node head = constructLL(arr);
		System.out.printf("LL palindrome? %b",isPalindrome(head));
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
