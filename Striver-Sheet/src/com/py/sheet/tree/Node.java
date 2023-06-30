package com.py.sheet.tree;

public class Node {
    public int data;
    public Node left,right;

    public Node(int data,Node left,Node right){
        this.data=data;
        this.left=left;
        this.right=right;
    }
    public Node(int data){
        this(data,null,null);
    }
    public Node(){
        this(Integer.MIN_VALUE);
    }

    // Function to insert a node in a BST.
    public static 
    Node insertBST(Node root, int key) {
        // your code here
        if(root==null)
            return new Node(key);
        Node parent = null, curr=root;
        while(curr!=null){
            if(curr.data==key)  return root;
            parent = curr;
            if(curr.data> key) curr = curr.left;
            else curr = curr.right;
        }
        if(parent.data>key) parent.left=new Node(key);
        else parent.right  = new Node(key);
        return root; 
    }

    public
    static String preOrderTraversal(Node root){
        if(root==null)  return "{EMPTY_TREE}";
        StringBuilder preorder = new StringBuilder();
        preorder.append('[');
        preorder(root, preorder);
        preorder.append(']');
        return preorder.toString();
    }

    private static void
    preorder(Node node,StringBuilder stb){
        stb.append(node.data);
        stb.append(" ");
        if(node.left!=null) preorder(node.left, stb);
        if(node.right!=null) preorder(node.right,stb);
    }
}
