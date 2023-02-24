package com.py.sheet.linkedList.medium;

import com.py.sheet.linkedList.easy.Node;

public class Q24_AddTwoLL {
 
	private static int len1= 0;
	static Node reverse(Node head) {
        // code here
        if(head ==null || head.next == null)
            return head;
        Node prev = null;
        Node curr = head;
        Node next = curr.next;
        while(curr.next!=null){
        	len1++;
            next = curr.next;
            curr.next =prev;
            prev = curr;
            curr = next;
        }
        curr.next=prev;
        len1++;
        return curr;
    }
	
	//Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
    	Node large = first,small= second;
    	large = reverse(first);
    	int lenLar = len1;
    	len1=0;
    	small = reverse(small);
//    	int smallLen = len1;
    	if(len1>lenLar) {
    		Node temp = large;
    		lenLar+=len1;
    		len1=lenLar-len1;
    		lenLar -=len1;
    		
    		large= small;
    		small =temp;
    	}
    	Node t1=large, t2=small,prev=null;
//    	System.out.println("large :: "+large+"  " + lenLar);
//    	System.out.println("small :: "+small+"  " + len1);
    	int carry=0;
    	while(t2!=null) {
//    		if(t1 == null)
//    			break;
    		int sum=t1.data + t2.data+carry;
    		if(sum>9) {
    			carry = sum/10;
    			sum=sum%10;
    		}else {
    			carry=0;
    		}
    		t1.data=sum;
    		prev=t1;
    		t1= t1.next;
    		t2 =t2.next;
    	}
//    	System.out.println("carry " +carry);
    	while(carry!=0) {
    		if(t1!=null) {
    			int sum= t1.data+carry;
    			carry=sum/10;
    			t1.data=sum%10;
    			prev =t1;
    			t1 = t1.next;
    		}else {
    			prev.next = new Node(carry);
    			carry/=10;
    		}
    	}
    	large= reverse(large);
    	return large;
    }
    
	public static void main(String[] args) {
		int arr1[]= {4,3,2,5,6 ,7};//{0,1,4,5,8,9,1};
		int arr2[] = {5 ,7 ,9 ,9 ,9 ,8 ,5 ,5, 3,9,2,9,8,7};
		System.out.println(arr1.length + "  "+ arr2.length);
		Node h1 = constructLL(arr1);
		Node h2 = constructLL(arr2);
		
		System.out.printf("added %s",addTwoLists(h1, h2));
		
			
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
