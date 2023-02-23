package com.py.sheet.linkedList.easy;

public class Q17_DeleteMiddleNode {

	static
	Node deleteMid(Node head) {
        // This is method only submission.
        // You only need to complete the method.
        if(head == null)
        	return head;
        if(head.next==null)
        	return head=null;
        Node t=head;
        int count=0;
        while(t!=null) {
        	count++;
        	t=t.next;
        }
        int mid = 1+count/2;
        t=head;
        mid-=2;
        while(mid>0) { // reaching element before that and element after that
        	mid--;
        	t=t.next;
        }
        Node delete = t.next;
        t.next = t.next.next;
        // dereferecing to node hopping garbage collector would do the work
        delete.next = null;
        delete=null;
        return head;
    }
	
	public static void main(String[] args) {
		int arr[]= {2,1,3};//{2,1,4,5,8,19,10};
		Node head = constructLL(arr);
		System.out.println("orginal:: "+deleteMid(head));
		
	}

	static Node constructLL(int arr[]){
        // code here
        Node head=null;
        Node last=null;
        for(int i=0; i<arr.length; i++){
            if(head==null){
                head=new Node(arr[i]);
                last=head;
            }else{
                last.next=new Node(arr[i]);
                last=last.next;
            }
        }
        return head;
    }
}
