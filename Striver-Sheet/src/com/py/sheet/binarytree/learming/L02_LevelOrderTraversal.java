package com.py.sheet.binarytree.learming;

import java.util.*;

public class L02_LevelOrderTraversal {
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
        // levelOrderTravsersal(root);
        root.left.left = new Node(40);
        root.right.left = new Node(60);
        root.right.left.right = new Node(90);
        levelOrderTravsersal(root);
        System.out.println();
    }
    static 
    void levelOrderTravsersal(Node root){
        if(root == null)    return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(q.isEmpty() == false){
            /*
             * I guess .poll() or remove() both methods will
             *  work fine
             */
            Node current = q.remove(); //This method is used to retrieve 
            //  and removes the head of the queue, or returns null if the queue is empty.
            System.out.printf(" %d", current.data);
            if(current.left !=null)
                q.add(current.left);
            if(current.right != null)
                q.add(current.right);
        }
    }
}
