package com.py.sheet.linkedList.easy;

class Q12_ReverseLL {

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
	
	public static void main(String[] args) {
		int arr[] = {};//{1,2,3,4,5,6,};//{2};//
		Node head = constructLL(arr);
		System.out.println(reverseList(head));
	}
	
	//Function to reverse a linked list.
	static
	Node reverseList(Node head){
        // code here
        if(head ==null || head.next == null)
            return head;
        Node prev = null;
        Node curr = head;
        Node next = curr.next;
        while(curr.next!=null){
            next = curr.next;
            curr.next =prev;
            prev = curr;
            curr = next;
        }
        curr.next=prev;
        return curr;
    }

}
