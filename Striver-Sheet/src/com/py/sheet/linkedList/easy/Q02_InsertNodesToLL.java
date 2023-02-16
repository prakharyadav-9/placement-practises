package com.py.sheet.linkedList.easy;

public class Q02_InsertNodesToLL {

	//Function to insert a node at the beginning of the linked list.
    Node insertAtBeginning(Node head, int x){
        // code here
    	return head;
    }
    
    //Function to insert a node at the end of the linked list.
    Node insertAtEnd(Node head, int x){
        // code here
    	return head;
    }
    
	public static void main(String[] args) {
		int arr[]= {2,1,4,5,8,19,10};
		Node head = constructLL(arr);
		
		recursiveDisplayLL(head);		

	}

	private static void recursiveDisplayLL(Node head) {
		if(head.next==null) {
			System.out.println("null");
			return ;
		}else {
			System.out.print(head.data + "->");
			recursiveDisplayLL(head.next);
		}
		
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
