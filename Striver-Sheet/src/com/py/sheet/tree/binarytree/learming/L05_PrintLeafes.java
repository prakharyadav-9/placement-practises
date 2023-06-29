package com.py.sheet.tree.binarytree.learming;

import java.util.*;

import com.py.sheet.tree.binarytree.questions.Node;

public class L05_PrintLeafes {
    
    public static void
    main(String...args){
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
        // root.left = new Node(20);
        root.right = new Node(30);
        // root.left.left = new Node(40);
        // root.left.right = new Node(70);
        // root.right.left = new Node(60);
        // root.right.left.right = new Node(90);;
        printLeaves(root);
        System.out.println();
    }

    static void 
    printLeaves(Node node){
        if(node == null)
            return;
        if(isLeaf(node)){
            System.out.printf("%d ",node.data);
        }else{
            if(node.right!=null) printLeaves(node.right);
            if(node.left!=null) printLeaves(node.left);
        }
    }
    private static
    boolean isLeaf(Node node){
        return node.left == null && node.right == null;
    }
}
