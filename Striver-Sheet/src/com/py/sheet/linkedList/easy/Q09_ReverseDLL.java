package com.py.sheet.linkedList.easy;

class Q09_ReverseDLL {

	public static NodeD reverseDLL(NodeD  head){
		//Your code here
	    if(head == null || head.next == null)
	        return head;
	    NodeD curr=head;
	    NodeD next=curr.next;
	    curr.next=null;
	    curr.prev=next;
	    while(next!=null){
	        next.prev=next.next;
	        next.next=curr;
	        curr=next;
	        next=next.prev;
	    }
	    head=curr;
	    return head;
	}
	public static void main(String[] args) {
		int arr[] = {1,2};//{1,2,3,4,5};//{2};//
		NodeD head =constructDLL(arr);
//		System.out.println(head);
		head  = reverseDLL(head);
		System.out.println(head);
	}

	static
	NodeD constructDLL(int arr[]) {
        // Code here
		NodeD  head = null;
		NodeD  last = head;
		for(int i=0;i<arr.length;i++) {
			NodeD newNode = new NodeD(arr[i]);
			if(head==null) {
				last=head=newNode;
			}else {
				while(last.next!=null) {
					last = last.next;
				}
				newNode.prev = last;
				last.next = newNode;
			}
		}
        return head;
    }
}
