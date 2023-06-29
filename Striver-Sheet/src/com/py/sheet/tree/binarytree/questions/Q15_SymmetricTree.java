package com.py.sheet.tree.binarytree.questions;

public class Q15_SymmetricTree {
    public static void
    main(String args[]){
        Node root=new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(70);
        root.right.left = new Node(60);
        root.right.left.right = new Node(90);
        boolean isSymmetric = isSymmetric(root);
        System.out.println(isSymmetric);
    }
    private static boolean isEqual(Node n1, Node n2){
        if(n1==null && n2==null)    return true;
        if(n1==null || n2==null)    return false;
        if(n1.data!=n2.data)    return false;
        return isEqual(n1.left,n2.right) && isEqual(n1.right,n2.left);
    }
    public static boolean isSymmetric(Node root){
        // add your code here;
        if(root==null)  return true;
        return isEqual(root.left,root.right);
    }
}
