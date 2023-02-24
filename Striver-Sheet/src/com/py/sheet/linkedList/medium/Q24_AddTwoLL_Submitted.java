package com.py.sheet.linkedList.medium;

import com.py.sheet.linkedList.easy.Node;

public class Q24_AddTwoLL_Submitted { //Function to add two numbers represented by linked list.

    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
        Node newFirst= reverse(first);
        Node newSecond= reverse(second);
        Node dummy1=newFirst;
        Node dummy2=newSecond;
        int count=0;
        while(dummy1.next!= null && dummy2.next!= null){
            int val= dummy1.data+dummy2.data+count;
          //  System.out.println(val);
            if(val>9){
                val=val-10;
                count=1;
                dummy1.data= val;
        //    System.out.println(dummy1.data);
            }
            else{
                dummy1.data= val;
                count=0;
            }
            dummy1=dummy1.next;
            dummy2=dummy2.next;
        }
         int val= dummy1.data+dummy2.data+count;
            if(val>9){
                val=val-10;
                count=1;
                dummy1.data= val;
            }
            else{
                dummy1.data= val;
                count=0;
            }
        while(dummy1.next!= null) {
            dummy1=dummy1.next;
            val=dummy1.data+count;
            if(val>9){
                val=val-10;
                count=1;
            }
            else
            	count=0;
            dummy1.data=val;
        }
        if(dummy2!= null)
            dummy1.next=dummy2.next;
        while(dummy2.next!= null){
            dummy2=dummy2.next;
            val=dummy2.data+count;
            if(val>9){
                val=val-10;
                count=1;
            }
            else
            	count=0;
            dummy2.data=val;
        }
        if(count==1){
            dummy1.next= new Node(1);
            dummy1=dummy1.next;
            dummy1.next= null;}
        return reverse(newFirst);
    }

    public static Node reverse(Node head){
        if(head== null || head.next== null) 
        	return head;
        Node newHead= reverse(head.next);
        head.next.next= head;
        head.next= null;
        return newHead;

    }
}
