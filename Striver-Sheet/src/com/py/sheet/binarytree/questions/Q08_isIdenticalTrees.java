package com.py.sheet.binarytree.questions;

public class Q08_isIdenticalTrees {
    public static void 
    main(String...args){
        //T1
        Node root1=new Node(10);
        root1.left = new Node(20);
        root1.right = new Node(30);
        root1.left.right = new Node(70);
        root1.left.left = new Node(40);
        root1.right.left = new Node(60);
        root1.right.left.right = new Node(90);
        // T2
        Node root2=new Node(10);
        root2.left = new Node(20);
        root2.right = new Node(30);
        root2.left.right = new Node(70);
        root2.left.left = new Node(40);
        root2.right.left = new Node(60);
        // root2.right.left.right = new Node(90);
        boolean isIdentical = isIdentical(root1,root1);
        System.out.println(isIdentical);
    }

    //Function to check if two trees are identical.
    static
	//Function to check if two trees are identical.
	boolean isIdentical(Node root1, Node root2){
	    if(root1==null && root2==null)
	        return true;
	    if(root1!=null && root2!=null){
	        return (root1.data== root2.data) 
	            && isIdentical(root1.left,root2.left)
	                &&isIdentical(root1.right,root2.right);
	    }
	    return false;
	}
}
