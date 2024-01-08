package com.py.revision;

public class Q2_23_10_16 {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
     }
     static class LinkedList{
        Node head;
     }
     public static void main(String ...args){
        int arr[] = {5,10,6,8,1,10,11,2,6,9,8,7,};
        LinkedList l1 = new LinkedList();
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);
        l1.head = n1;
        
        LinkedList l2 = new LinkedList();
        Node n2 = new Node(0);
        n2.next = new Node(0);
        n2.next.next = new Node(5);


     }
     void addLL(LinkedList l1,LinkedList l2){
        Node rev1 = reverse(l1.head);
        Node rev2 = reverse(l2.head);
        int carr=-1;;
        LinkedList ans = new LinkedList();
        Node t1 = rev1, t2 = rev2,t3 =null;
        while(null!=t1 && null !=t2){
            int addedData = t1.data +t2.data+carr;
            Node  tNOde = new Node(addedData%10);
            if(ans.head==null)
                ans.head =t3 = tNOde;
            else {
                t3.next = tNOde;
                // t3
            }
            carr = addedData/10;
        }

     }
     Node reverse(Node node ){
        if(node ==null || null == node.next){
            return node;
        }
        Node prev = null;
        Node curr = node;
        Node next = curr.next;
        while(next!=null){
            curr.next = prev;
            prev = curr;
            curr = next;
            next = curr.next;
        }
        return curr;
     }
}
