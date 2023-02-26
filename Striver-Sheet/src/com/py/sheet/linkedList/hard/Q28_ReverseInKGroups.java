package com.py.sheet.linkedList.hard;

import com.py.sheet.linkedList.easy.Node;

public class Q28_ReverseInKGroups {
	
	// sbumitteed
	public static Node reverse(Node node, int k){ //Your code here
        Node prev=null;
        Node curr=node;
        Node nextNode=null;
        int count=0;
        while(curr!=null && count<k){
            nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
            count++;
        }
        if(nextNode!=null){
            node.next=reverse(nextNode, k);
        }
        return prev;
        
    }
	

	/*
	 * implemented
	 */
//	public static Node reverse(Node head, int k){
//        //Your code here
//		if(head==null||head.next == null)
//			return head;
//		if(k==1)
//			return head;
//		Node dummy = new Node(-1);
//		dummy.next=head;
//		Node curr = dummy, prev= dummy, next = dummy;
//		int count =0;
//		while(curr!=null) {
//			count++;
//			curr=curr.next;
//		}
////		System.out.printf("count %d\n",count);
//		while(count>=k) {
//			curr = prev.next;
//	        next = curr.next;
//	        for(int i=1;i<k;i++) {
//	            curr.next = next.next;
//	            next.next = prev.next;
//	            prev.next = next;
//	            next = curr.next;
//	        }
//	        prev = curr;
//			count-=k;
//		}
//		return dummy.next;
//	}
	
	public static void main(String[] args) {
		int arr[] = {1,2};//{1,2,2,4,5,6,7,8,};//{1,2,3,4,5};//{2};//
		Node head=null;
		int k=1;
		head=constructLL(arr);
		System.out.println(head);
		head = reverse(head, k);
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
