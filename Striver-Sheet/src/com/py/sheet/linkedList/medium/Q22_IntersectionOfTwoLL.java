package com.py.sheet.linkedList.medium;

import java.util.HashMap;
import java.util.Map;

import com.py.sheet.linkedList.easy.Node;

public class Q22_IntersectionOfTwoLL {

	public static Node findIntersection(Node head1, Node head2){
        // add your code here
        // return the head of intersection list
		Node head=null,last=null;
        Map<Integer,Node> nodes = new HashMap<>();
        while(head2!=null) {
        	nodes.put(head2.data,head2);
        	head2 = head2.next;
        }
        while(head1!=null) {
        	if(nodes.containsKey(head1.data)) {
        		if(last == null) {
        			head=last=nodes.get(head1.data);
        			last.next=null;
        		}else {
        			last.next=nodes.get(head1.data);
        			last=last.next;
        		}
        	}
        	head1=head1.next;
        }
        last.next=null;
		return head;
    }
	
	public static void main(String[] args) {
		int arr1[]= {9,6,4,2,3,8,};
		int arr2[]= {1,2,8,6};
		Node h1 = constructLL(arr1), h2 = constructLL(arr2);
		System.out.println(findIntersection(h1, h2));
		
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
