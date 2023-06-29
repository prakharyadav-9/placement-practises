package com.py.sheet.tree.binarytree.questions;

import java.util.*;

public class Q06_MaxWidth {
    
    public static void
    main(String ...args){
        Node root=new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.right = new Node(70);
        root.left.left = new Node(40);
        root.right.left = new Node(60);
        root.right.left.right = new Node(90);
        int maxWidth = getMaxWidth(root);
        System.out.println(maxWidth);
    }
    static
    int getMaxWidth(Node root) {
        // Your code here
        int maxWidth = 1;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(q.isEmpty() == false){
            int count = q.size();
            maxWidth = Math.max(maxWidth,count);
            for(int i=0;i<count;i++){
                Node curr = q.poll();
                // System.out.printf("%d ",curr.data);
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            // System.out.println();
        }

        return maxWidth;
    }
}
