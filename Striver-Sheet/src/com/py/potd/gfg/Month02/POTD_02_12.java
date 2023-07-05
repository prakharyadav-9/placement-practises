package com.py.sheet.potd.gfg.Month02;

public class POTD_02_12 {

	static Node primeList(Node head){
        //code here
		Node t=head;
        while(t!=null) {
        	if(!isPrime(t.val)){
        		t.val = findNearestPrime(t.val);        		
        	}
        	t = t.next;
        }
        return head;
    }
	private static int findNearestPrime(int val) {
		int less=val-1, high = val+1;
		while(!isPrime(less)) {
			less--;
		}	
		while(!isPrime(high)) {
			high++;
		}
		return (Math.abs(val-less)>Math.abs(high-val))?high:less;
	}
	static boolean isPrime(int  num) {
		if(num==1 || num == 0)
			return false;
		for(int i=2;i<=Math.sqrt(num);i++) {
			if(num%i==0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		Node n1 = new Node(15);
		Node n2 = new Node(20);
//		Node n3 = new Node(2);
//		Node n4 = new Node(2);
//		Node n5 = new Node(2);
		head.next = n1;
		n1.next=n2;
		printList(head);
		printList(primeList(head));
	}
	
	static void printList(Node head) {
		while(head!= null) {
			System.out.print(head.val+"->");
			head = head.next;
		}
		System.out.println(""+null);
	}
	
	static class Node{
	    Node next;
	    int val;
	    public Node(int data){
	        val=data;
	        next=null;
	    }
	}

}
