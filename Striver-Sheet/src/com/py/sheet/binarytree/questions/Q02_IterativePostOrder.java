package com.py.sheet.binarytree.questions;

import java.util.*;

public class Q02_IterativePostOrder {
    
    private static class Node{
        Node right, left;
        int data;
        Node(int data){
            this.data = data;
        }
    }    

    /*
     *      root = 10
     *      /       \
     *      20      30
     *      /\      /
     *     40 70    60
     *                \ 
     *                  90
     */
    public static 
    void main(String...args){
        Node root=new Node(10);
        // levelOrderTravsersal(root);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(70);
        root.right.left = new Node(60);
        root.right.left.right = new Node(90);
        List<Integer> res = postOrder(root);
        System.out.println();
        System.out.println(res);
        res = postOrder(root);
        System.out.println();
        System.out.println(res);
        System.out.println();
    }

    static
    ArrayList<Integer> postOrder(Node node) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        if(node == null)
            return res;
        Stack<Node> q = new Stack<>();
        q.add(node);
        while(q.isEmpty()==false){
            Node curr = (Node) q.pop();
            res.add(curr.data);
            // System.out.printf("%d ",curr.data);
            if(curr.left!= null)
                q.add(curr.left);
            if(curr.right != null)
                q.add(curr.right);
        }
        Collections.reverse(res);
        return res;    
    }
}
