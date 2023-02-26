package com.py.sheet.linkedList.hard;
//{ Driver Code Starts
import java.util.Scanner;

import com.py.sheet.linkedList.easy.Node;

import java.util.*;
import java.io.*;

/*
 * 
 * making in local requires lots of effort focus on logic for now
 * will do it in the website itself
 */


class Q30_Flatttening_A_LinkedList
{
	static
	void printList(Node1 head)
    {
        //Node temp = head;
        while (head != null)
        {
            System.out.print(head.data + " ");
            head =head.bottom;
        }
        System.out.println();
    }

	static class Node1
	{
		int data;
		Node1 next;
		Node1 bottom;
		
		Node1(int d)
		{
			data = d;
			next = null;
			bottom = null;
		}
		
	}
	static
	Node1 flatten(Node1 root){
		// Your code here
		return root;
	}
	
	public static void main(String ...args) {
		int arr[][] = {
				{5,7,8,30},
				{10,20},
				{19,22,50},
				{28,35,40,45,},
					};//{1, 2, 3, 4, 5, 6, 7, 8};//{2, 4, 7, 8, 9};//{1,2,2,4,5,6,7,8,};//{1,2,3,4,5};//{2};//
		Node1 head=null;
		int k=1;
		head=constructSpecialLL(arr);
//		head = flatten(head);
//		System.out.println(head);
		System.out.println("List is::");
		printList(head);
		
	}
	
	static Node1 constructSpecialLL(int arr[][]) {
        // code here
		if(arr.length==0)
			return null;
		Node1 head = new Node1(arr[0][0]),t=head;
		for(int levels[]:arr) {
			Node1 tLevel =t;
			for(int element: levels) {
				if(tLevel == null) {
					tLevel = new Node1(element);
				}
				tLevel = tLevel.bottom;
			}
			if(t.next==null)
				t.next= new Node1(levels[0]);
			t = t.next;
		}
		return head;
    }
}