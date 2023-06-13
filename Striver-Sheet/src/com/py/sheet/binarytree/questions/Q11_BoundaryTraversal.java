package com.py.sheet.binarytree.questions;

import java.util.*;

public class Q11_BoundaryTraversal {
    public static void 
    main(String args[]){
        /*
         *      10
         *     /  \
         *    20   30 
         *   /  \  / 
         *  40 70 60 
         *          \
         *          90
         * 
         */

        Node root=new Node(10);
        // root.left = new Node(20);
        // root.right = new Node(30);
        // root.left.right = new Node(70);
        // root.left.left = new Node(40);
        // root.right.left = new Node(60);
        // root.right.left.right = new Node(90);
        List<Integer> ans =null;
        ans = boundary(root);
        System.out.println(ans);
    }
    static
    ArrayList <Integer> boundary(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null)    return ans;
        ans.add(root.data);
        if(root.left!=null) addLeftView(root.left,ans);
        if(!isLeaf(root)) addLeafs(root,ans);
        if(root.right !=null) addRightView(root.right,ans);
        return ans;
	}
    private static void addRightView(Node right, ArrayList<Integer> ans) {
        ArrayList<Integer> temp = new ArrayList<>();
        Node curr = right;
        while(curr!=null){
            if(isLeaf(curr)==false) temp.add(curr.data);
            curr = curr.right !=null?curr.right:curr.left;
        }
        Collections.reverse(temp);
        ans.addAll(temp);
    }
    private static void addLeafs(Node node, ArrayList<Integer> ans) {
        if(node == null )
            return;
        if(isLeaf(node)){
            ans.add(node.data);
        }else{
            if(node.left !=null)    addLeafs(node.left,ans);
            if(node.right !=null)   addLeafs(node.right,ans);
        }
    }
    private static boolean isLeaf(Node node) {
        return node.left== null&& node.right == null;
    }
    private static void addLeftView(Node left, ArrayList<Integer> ans) {
        Node curr = left;
        while(curr!=null){
            if(isLeaf(curr) == false) ans.add(curr.data);
            curr = curr.left==null?curr.right:curr.left;
        }
    }
}
