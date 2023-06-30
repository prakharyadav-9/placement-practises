package com.py.sheet.tree.bst.questions;

import com.py.sheet.tree.Node;

public class Q01_BSTDeleteNode {
    /*
     * https://practice.geeksforgeeks.org/problems/delete-a-node-from-bst/1
     */

     public static void
     main(String...args){
        int elements[] = {50,30,70,40,60,80};
        Node root =null;
        for(int element:elements){
            root = Node.insertBST(root, element);
        }
        String preorder  = Node.preOrderTraversal(root);
        System.out.println(preorder);
        Node deleted = deleteNode(root, 40);
        preorder = Node.preOrderTraversal(deleted);
        System.out.println(preorder);

     }
    private static 
    Node insertNode(Node root,Node target){
        if(root==null)  return target;
        if(root.data>target.data){
            root.left = insertNode(root.left,target);
        }
        else{
            root.right = insertNode(root.right,target);
        }
        return root;
    }
    // Function to delete a node from BST.
    public static Node deleteNode(Node root, int x) {
        // code here.
        if(root==null) return root;
        if(root.data==x){
            if(root.left!=null){
                if(root.right!=null){    
                    return insertNode(root.left,root.right);
                }
                else return root.left;
            }else{
                return root.right;
            }
        }
        if(x<root.data) root.left = deleteNode(root.left,x);
        else root.right = deleteNode(root.right,x);
        return root;
    }
}
