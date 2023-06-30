package com.py.sheet.tree.bst.questions;
import com.py.sheet.tree.Node;
public class Q02_CheckIsBST {
    public static void
    main(String args[]){
        int elements[] = {10 ,13 ,11 ,5 ,8,2,7, 9};//{2, 1 ,3,};
        Node root=null;
        for(int element:elements){
            root = Node.insertBST(root,element);
        }
        boolean ans= false;
        //isBST(root);
        /*
         *         11
         *        /  \
         *       9    15
         *     /  \  
         *    5   10
         */
        root = new Node(11);
        root.left=new Node(9);
        root.right = new Node(15);
        root.left.left=new Node(5);
        root.left.right=new Node(10);

        ans = isBST(root);
        System.out.println(ans);
    }
    static boolean isBST(Node root){
        // code here.
        Node curr=root;
        Node last =null;// this would contain the last access element
        while(curr!=null){
            if(curr.left==null){
                if(last!=null&& last.data>=curr.data)  
                    return false;
                // System.out.printf("%d ",curr.data);
                last=curr;
                curr = curr.right;
            }else{
                Node prev=curr.left;
                while(prev.right!=null&&prev.right!=curr){
                    prev=prev.right;
                }
                if(prev.right==null){
                    // make thread
                    prev.right=curr;
                    // move to left
                    curr=curr.left;
                }else{
                    // System.out.printf("%d ",curr.data);
                    if(last.data>=curr.data)   
                        return false;
                    prev.right=null;
                    last=curr;
                    curr=curr.right;
                }
            }
        }
        // System.out.println();
        return true;
    }
}
