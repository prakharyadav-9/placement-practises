package com.py.sheet.linkedList.easy;

public class Q15_SegregateEvenAndOdd {

	static class LL{
		Node head;
		Node last;
		LL (Node head){
			this.head= head;
		}
		@Override
		public String toString() {
			return "["+this.head+"]";
		}
	}
	
	
	static
	void addLastAndRemoveFirst(LL fromList,LL toHead) {
		if(fromList.head==null )
			return ;
		
		Node capturedNode = fromList.head;
		fromList.head = capturedNode.next;
		capturedNode.next =null;
		if(toHead.head==null) {
			toHead.head = toHead.last = capturedNode;
		}else {
			toHead.last.next=capturedNode;
			toHead.last = toHead.last.next;
		}
//		return capturedNode;
	}
	static
	Node divide(int N, Node head){
        // code here
		LL evens=new LL(null);
		LL odds = new LL(null);
		LL givenLL = new LL(head);
		while(givenLL.head!=null) {
			if(givenLL.head.data%2==0) {
				addLastAndRemoveFirst(givenLL, evens);
			}else {
				// odd data
				addLastAndRemoveFirst(givenLL,odds);
			}
		}
		if(evens.last ==null) {
			return odds.head;
		}
		evens.last.next = odds.head;
		return evens.head;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,3,5};//{1,2,3,4,5,6,7,8,9};//{2};//
		int n = arr.length;
		Node head = constructLL(arr);
		System.out.println(divide(n, head));
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
