package com.py.sheet.tree.bst.questions;

import com.py.sheet.tree.Node;

public class Q03_KthSmallestElement {
    public static void 
    main(String args[]){
        int elements[] = {2,1,3};
        Node root=null;
        for(int element:elements){
            root =Node.insertBST(root,element);
        }
        int k=1;
        int res = -1;
        res = KthSmallestElement(root,k);
        // String preorder = Node.preOrderTraversal(root);
        // System.out.println(preorder);
        System.out.println(res);

    }
    static
    // Return the Kth smallest element in the given BST
    public int KthSmallestElement(Node root, int k) {
        // Write your code here
        int res=-1;
        // again morris treaversal woul be very handy
        Node curr=root;
        while(curr!=null){
            if(curr.left==null){
                k--;
                if(k==0){
                    res=curr.data;
                    break;
                }
                curr=curr.right;
            }else{
                Node prev=curr.left;
                while(prev.right!=null&&prev.right!=curr){
                    prev=prev.right;
                }
                if(prev.right==null){
                    prev.right=curr;
                    curr=curr.left;
                }else{
                    k--;
                    if(k==0){
                        res=curr.data;
                        break;
                    }
                    curr=curr.right;
                    prev.right=null;
                }
            }
        }
        return res;
    }
}
