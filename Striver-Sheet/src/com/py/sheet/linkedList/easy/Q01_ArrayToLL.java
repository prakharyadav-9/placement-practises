package com.py.sheet.linkedList.easy;

public class Q01_ArrayToLL {

	static Node constructLL(int arr[]) {
        // code here
		Node head = new Node(arr[0]);
		Node t=head;
		for(int i=1;i<arr.length;i++) {
			Node node = new Node(arr[i]);
			t.next=node;
			t=t.next;
		}
		return head;
    }
	
	public static void main(String[] args) {
		int arr[] = {2};//{1,2,3,4,5};
		System.out.println(constructLL(arr));

	}

}
