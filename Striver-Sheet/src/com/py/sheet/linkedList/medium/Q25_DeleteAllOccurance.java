package com.py.sheet.linkedList.medium;

import com.py.sheet.linkedList.easy.NodeD;

public class Q25_DeleteAllOccurance {

	static NodeD deleteAllOccurOfX(NodeD head, int x) {
        // Write your code here
		NodeD t= head;
		
		while(head!=null && head.data==x) {
			t=head;
			head= head.next;
			t.prev=t.next=null;
		}
		if(head == null)
			return head;
		head.prev = null;
		t=head;
		while(t!=null) {
			NodeD temp=t.next;
			if(t.data == x) {
				if(t.prev!=null) {
					t.prev.next = t.next;
					if(t.next!=null) {
						t.next.prev = t.prev;
						
					}
				}else {
					t.next.prev = t.prev;
				}
				t.prev=null;
				t.next=null;
			}
			t= temp;//t.next;
		}
		return head;
	}
//	static NodeD t=null;
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
//		t= last.next;
        return head;
    }

	public static void main(String[] args) {
		int arr[] = {2,2,1,2};//{2,2,10,8,4,2,5,2,};
		int x=02;
		NodeD head = constructDLL(arr);
		System.out.println(head);
		head = deleteAllOccurOfX(head, x);
		System.out.println(head);
//		while(t.prev!=null) {
//			System.out.print(t.data+ "->");
//			t = t.prev;
//		}
//		System.out.println(t.data+"->null");
	}

	
}
