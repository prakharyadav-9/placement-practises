package com.py.sheet.binarytree.questions;



public class Q21_TreeConstPreInorder {
    
    private static void printPreOrder(Node node){
        if(node==null){  System.out.print(" "); return;}
        System.out.print(node.data+ " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    public static void
    main(String...args){
        int pre[] = {1 ,6 ,7 ,8,};
        int in[] = {1, 6, 8, 7,};
        Node root = buildTree(in, pre,pre.length);
        printPreOrder(root);

    }
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        Node root = build(inorder, 0, n-1, preorder, 0, n-1);
        return root;
    }
    
    public static Node build(int inorder[], int inSt, int inEn, int preorder[], int preSt, int preEn){
        if(inSt > inEn || preSt > preEn) return null;
        Node root = new Node(preorder[preSt]);
        int ind = 0;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == preorder[preSt]){
                ind = i;
                inorder[i] = -1;
                break;
            }
        }
        int leftnum = ind - inSt;
        root.left = build(inorder, inSt, ind-1, preorder, preSt+1, preSt + leftnum);
        root.right = build(inorder, ind+1, inEn, preorder, preSt + leftnum + 1, preEn);
        return root;
    }
}
