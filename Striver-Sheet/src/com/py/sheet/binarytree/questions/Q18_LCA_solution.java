package com.py.sheet.binarytree.questions;

public class Q18_LCA_solution {
    public static void 
    main(String...args){
        Node root=new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left= new Node(10);
        root.left.right.right = new Node(14);
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        int n1=7;
        int n2=11;
        root =  new Node(7);
        root.left = new Node(1);
        root.right = new Node(10);
        root.left.right =new Node(4);
        root.right.right =new Node(11);
        root.right.right.right = new Node(12);
        root.right.left=new Node(9);
        root.right.left.left = new Node(8);

        root = new Node(5);
        root.left = new Node(1);
        root.right =  new Node(9);
        root.left.right=new Node(4);
        root.right.left = new Node(7);
        Node lca = null;
        n1=9;
        n2 = 4;
        lca =lca(root,n1,n2);
        System.out.println("in main => lca.data = "+lca.data);
    }
    static
    //Function to return the lowest common ancestor in a Binary Tree.
	Node lca(Node root, int n1,int n2){
		// Your code here
        if(root==null)  return null;
        if(root.data ==n1 || root.data == n2)
            return root;
        Node lcaLeft = lca(root.left,n1,n2);
        Node lcaRight = lca(root.right,n1,n2);
        if(lcaLeft!=null &&lcaRight!=null)// got the ancestor
            return root;
        if(lcaLeft!=null) // left child will have ans
            return lcaLeft;
        else  // else right child has answer ancestor
            return lcaRight; 
    }
}
