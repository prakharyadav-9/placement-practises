package com.py.sheet.linkedList.medium;

import com.py.sheet.linkedList.easy.Node;

public class Q23_AddOne {

	public static Node addOne(Node head) { 
        //code here.
		head = reverseLL(head);
		Node t=head;
		boolean carry=false;
		while(t!=null) {
			t.data++;
			if(t.data>9) {
				t.data=0;
				t= t.next;
				carry=true;
			}else {
				carry=false;
				break;
			}
		}
		head = reverseLL(head);
		System.out.println(carry);
		if(carry) {
			Node msb = new Node(1) {
				@Override
				public String toString() {
					return this.data+ " "+((this.next!=null?this.next:""));
				}
			};
			msb.next=head;
			head=msb;
		}
		return head;
    }
	
	
	private static Node reverseLL(Node head) {
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

	public static void main(String[] args) {
		int arr[]= {9,9};//{0,1,4,5,8,9,1};
		Node head = constructLL(arr);
		System.out.printf("result of added one is= %s", addOne(head));
		
	}
	
	static Node constructLL(int arr[]){
        // code here
        Node head=null;
        Node last=null;
        for(int i=0; i<arr.length; i++){
            if(head==null){
                head=new Node(arr[i]) {
                	@Override
                	public String toString() {
                		return ""+this.data+" "+this.next;
                	}
                };
                last=head;
            }else{
                last.next=new Node(arr[i]){
                	@Override
                	public String toString() {
                		return ""+this.data+" "+((this.next!=null)?this.next:"");
                	}
                };
                last=last.next;
            }
        }
        return head;
    }

}
