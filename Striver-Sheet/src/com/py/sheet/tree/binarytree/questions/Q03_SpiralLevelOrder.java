package com.py.sheet.tree.binarytree.questions;

import java.util.*;

public class Q03_SpiralLevelOrder {
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
        List<Integer> res=null;
        // levelOrderTravsersal(root);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(70);
        root.right.left = new Node(60);
        root.right.left.right = new Node(90);
        res = findSpiral(root);
        System.out.println();
        System.out.println(res);
        /*
         *      1
         *    /   \
         *   3     2
         */
        root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        res = findSpiral(root);
        System.out.println();
        System.out.println(res);
        /*
         *      10
         *     /  \
         *    20  30
         *   /  \   
         *  40   60
         */
        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right =  new Node(60);
        res = findSpiral(root);
        System.out.println();
        System.out.println(res);
        System.out.println();
    }
    
    //Function to return a list containing the level order 
    //traversal in spiral form.	
    static
    ArrayList<Integer> findSpiral(Node root) {
        // Your code here
        ArrayList<Integer> finalResult = new ArrayList<>();
        if(root==null)
            return finalResult;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        boolean flag=true;
        List<Integer> levelTraversal = new ArrayList<>();
        while(q.size()>1){
            // System.out.println("Queue Size :: "+ q.size());
            Node curr = q.poll();
            if(curr == null){
                if(flag){
                    // indicates that we need to reverse the levelTraversal
                    Collections.reverse(levelTraversal);
                    // System.out.printf("flag changed!\n");
                }
                finalResult.addAll(levelTraversal);
                flag =!flag;
                levelTraversal.clear();
                // System.out.println();
                q.add(null);
                continue;
            }
            else{
                levelTraversal.add(curr.data);
                // System.out.printf("%d ",curr.data,levelTraversal);
                if(curr.left!= null)    q.add(curr.left);
                if(curr.right!= null)    q.add(curr.right);
            }
            // System.out.println();
        }
        if(flag){
            // indicates that we need to reverse the levelTraversal
            Collections.reverse(levelTraversal);
        }
        finalResult.addAll(levelTraversal);
        // System.out.println();
        // System.out.println("Queue Size :: "+ q.size());
        return finalResult;
    }

}
