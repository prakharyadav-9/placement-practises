package com.py.sheet.linkedList.medium;

import com.py.sheet.linkedList.easy.Node;

public class Q22_SortLL {

		
	static
	public Node sort(Node head){
        //your code here, return the head of the sorted list
        Node n1=head;
        Node n2=head.next;
        while(n2!=null || n1.next!=null){
            if(n1.data>n2.data){
                int t=n1.data;
                n1.data=n2.data;
                n2.data=t;
            } 
            n2=n2.next;
            if(n2==null){
                n1=n1.next;
                n2=n1.next;
            }
        }
        return head;
   }
	

	public static void main(String[] args) {
		int arr[] = {991,20,1000,19,1001,1};//{1,9,};
		Node head = constructLL(arr);
		System.out.println(head);
		System.out.println(sort(head));
		
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
