package com.py.sheet.tree.binarytree.questions;

import java.util.*;

public class Q09_ZigZagTraversal {
    
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
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.right = new Node(70);
        root.left.left = new Node(40);
        root.right.left = new Node(60);
        root.right.left.right = new Node(90);

        List<Integer> ans =null;
        ans = zigZagTraversal(root);
        System.out.println(ans);
    }
    static
    ArrayList<Integer> zigZagTraversal(Node root){
	    //Add your code here.
        /*
         * Approch is do level order traversal and perform
         * alternate reversal of nodes in level
         */
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        boolean flag = false;
        if(root == null )
            return ans;
        Queue<Node> q= new LinkedList<>();
        q.add(root);
        while(q.isEmpty() == false){
            int count = q.size();
            for(int i=0; i<count;i++){
                Node curr = q.poll();
                if(flag){
                    st.add(curr);
                }else{
                    ans.add(curr.data);
                }
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            flag ^=true;
            while(st.isEmpty() != true){
                ans.add(st.pop().data);
            }
        }
        return ans;
    }
}
