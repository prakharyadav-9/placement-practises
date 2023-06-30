package com.py.sheet.tree.binarytree.learming;

import java.util.*;

import com.py.sheet.tree.binarytree.questions.Node;

public class L07_MorrisTraversal {
    
    public static void main(String args[]){
        // create a BT
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
        List<Integer> res=new ArrayList<>();
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(70);
        root.right.left = new Node(60);
        root.right.left.right = new Node(90);;
        inOrderMorrisTraversal(root,res);
        // res = preOrderMorrisTraversal(root);
        // System.out.println(res);
        // res = preOrderMorrisTraversal(root);
        // System.out.println("second time-> "+res);
    }
    static void inOrderMorrisTraversal(Node root,List<Integer> res){
        Node curr=root;
        while(curr!=null){
            if(curr.left==null){
                // then print the node and go to right sub tree
                res.add(curr.data); // that itself is the root
                System.out.printf("%d ",curr.data);
                curr=curr.right;
            }
            else{ // there left is existing
                // go to the right most(last guy in inorder)
                Node prev = curr.left; // from curr.left go to last guy
                while(prev.right!=null&&prev.right!=curr) 
                    prev = prev.right;
                // now either of two cases might have happen

                // last gut is pointing to curr
                if(prev.right==null){
                    // then make the thread
                    prev.right=curr;
                    // now when thread is made
                    // we can do out traversal to the left subtree
                    curr = curr.left;
                }
                else{ // prev.right ==curr then print the node then jump right
                    res.add(curr.data);
                    System.out.printf("%d ",curr.data);
                    // and break the thread
                    prev.right=null;
                    // now we can curr can jump right
                    curr=curr.right;

                }
            }
        }
        System.out.println();
    }
    static 
    List<Integer> preOrderMorrisTraversal(Node root){
        List<Integer> res = new ArrayList<>();
        Node curr=root;
        while(curr!=null){
            if(curr.left==null){
                // then add the root and move to right
                res.add(curr.data);
                curr = curr.right;
            }else{
                // get the last guy in left sub tree
                Node prev = curr.left;
                while(prev.right!=null&&prev.right!=curr){
                    prev=prev.right;
                }
                if(prev.right==null){
                    // make a thread
                    prev.right=curr;
                    // add the data before moving to left sub tree
                    res.add(curr.data);
                    // then we may jump left 
                    curr=curr.left;
                }else{
                    // remove the thread connection
                    prev.right=null;
                    // move right
                    curr=curr.right;
                }
            }
        }
        return res;
    }
}
