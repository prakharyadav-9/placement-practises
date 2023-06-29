package com.py.sheet.tree.binarytree.questions;

import java.util.*;

public class Q05_DiameterofBT {
   
    public static void
    main(String args[]){

    /*
     *      root = 10
     *      /       \
     *      20      30
     *      /\      /
     *     40 70    60
     *                \ 
     *                  90
     */
        Node root=new Node(10);
        Integer res=null;
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(70);
        root.right.left = new Node(60);
        root.right.left.right = new Node(90);;
        res = diameterOfBinaryTree(root);
        System.out.println(res);
    }
    static
    int diameterOfBinaryTree(Node root){
        int res = 0;
        int lHeight=0,rHeight = 0;
        if(root==null)
            return res;
        int lDiameter = 0;
        int rDiameter = 0;
        if(root.left !=null){
            lDiameter = diameterOfBinaryTree(root.left);
            lHeight = hieghtOfTRee(root.left);
        }
        if(root.right !=null){
            rHeight = hieghtOfTRee(root.right);
            rDiameter = diameterOfBinaryTree(root.right);
        }
        int diameter = lHeight +rHeight +1;
        res = Math.max(Math.max(lDiameter,rDiameter),diameter);

        return res;
    } 
    static 
    int hieghtOfTRee(Node root){
        if( root == null)
            return 0;
        else 
            return Math.max(hieghtOfTRee(root.left),hieghtOfTRee(root.right))+1;
    }
}

