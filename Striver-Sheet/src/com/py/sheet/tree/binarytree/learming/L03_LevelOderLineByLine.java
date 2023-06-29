package com.py.sheet.tree.binarytree.learming;

import java.util.*;

public class L03_LevelOderLineByLine {
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
     * 
     * output :-
     * 10
     * 20 30
     * 40 70 60
     * 90
     */
    public static 
    void main(String...args){
        Node root=new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.right.left = new Node(60);
        root.right.left.right = new Node(90);
        levelOrderLineByLine_1(root);
        System.out.println();
        levelOrderLineByLine_2(root);
        System.out.println();
    }

    private static void levelOrderLineByLine_2(Node root) {
        if(root == null)
            return ;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(q.isEmpty() == false){
            // currently queue will have a level in it
            int count = q.size();
            for(int i=0;i<count;i++){
                Node curr = q.remove(); // grasp the node
                System.out.printf("%d ",curr.data); // print it
                // add next level
                if(curr.left != null)   q.add(curr.left);
                if(curr.right != null)  q.add(curr.right);
            }
            System.out.println();
        }
    }

    static 
    void levelOrderLineByLine_1(Node root) {
        if(root == null)
            return ;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null); // indicating the end of level at root
        while(q.size()> 1){
          /*
            why, q.size()>1?    
                because every time we will have 
                exactly one null in the  queue
                and at end of all nodes we will have a null
                indicating that last node has been ended
           */  
          Node curr = q.poll(); // taking out each level
          if(curr== null){
            // this means we encountered a level completion
            System.out.println();
            q.add(null); // adding null for another possible level
            continue;
          }
          System.out.printf("%d ",curr.data);
          if(curr.left !=null)  q.add(curr.left);
          if(curr.right != null) q.add(curr.right);
        }
    }
}
