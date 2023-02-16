package com.py.sheet.linkedList.easy;

public class Q01_ArrayToLL {

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
		int arr[] = {};//{1,2,3,4,5};//{2};//
		Node head=null;
		System.out.println(head=constructLL(arr));
		System.out.println(getMiddle(head));

	}
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
        temp=head;
        while(temp!=null && mid>1){
            temp= temp.next;
            mid--;
        }
        return temp!=null?temp.data:-1;
   }

}
