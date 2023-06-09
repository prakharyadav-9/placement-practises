package com.py.sheet.binarytree.questions;

import java.util.*;

public class Q04_BalancedOrNot {
    
    public static 
    void main(String...args){
        Node root= null;
        // root =new Node(10);
        // levelOrderTravsersal(root);
        /*
         *      10
         *     /   \
         *    20    30
         *   /  \   / \
         *  40  70 60 90 
         */
        // root.left = new Node(20);
        // root.right = new Node(30);
        // root.left.left = new Node(40);
        // root.left.right = new Node(70);
        // root.right.left = new Node(60);
        // root.right.left.right = new Node(90);
        /*
         *      10
         *      /
         *     20
         *      \
         *      30
         */
        // root = new Node(10);
        // root.left = new Node(20);
        // root.left.right = new Node(30);
        /*
        *      1
         *    /   \
         *   3     2
         */
        // root = new Node(1);
        // root.left = new Node(3);
        // root.right = new Node(2);
        // System.ot.println(res);
        // /*
        //  *      10
        //  *     /  \
        //  *    20  30
        //  *   /  \   
        //  *  40   60
        //  */
        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right =  new Node(60);
        boolean isBalanced = isBalanced(root);
        System.out.println();
        System.out.println("given tree:: isBalanced:: "+isBalanced);
    }
    
    static
    boolean isBalanced(Node root){
    	// Your code here
        if(root==null)
            return true;
        if(root.left !=null)
            if( isBalanced(root.left) == false)
                return false;
        if(root.right!=null && (isBalanced(root.right) == false)) 
            return false;    
        int nLT = height(root.left);
        int nRT = height(root.right);
        if(Math.abs(nLT - nRT) >1)
            return false;
        return true;
    }
    private static 
    int height(Node root){
        if(root == null)
            return 0;
        
        return 1+ Math.max(height(root.left), height(root.right));
    }
}
