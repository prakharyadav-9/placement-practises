package com.py.sheet.linkedList.medium;

import com.py.sheet.linkedList.easy.NodeD;

public class Q27_RemoveDuplicatesFromSortedLL {

	static NodeD removeDuplicates(NodeD head){
        // Code Here.
        if(head==null || head.next==null) {
        	return head;
        }
        NodeD t=head,tNext = t.next;
		while(t.next!=null) {
			if(t.data== tNext.data) {
				t.next=tNext.next;
				tNext.prev = null;
				tNext =tNext.next;
				if(tNext==null)
					break;
				tNext.prev.next = null;
				tNext.prev = t;
			}else {
				t=tNext;
				tNext=tNext.next;
			}
		}
		return head;
    }
	
	public static void main(String[] args) {
		int arr[]= {4,4,4,4,4};//{1,1,1,2,3,3,4};
		NodeD head = constructDLL(arr);
		head = removeDuplicates(head);
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
//		t= last.next;
        return head;
    }
}
