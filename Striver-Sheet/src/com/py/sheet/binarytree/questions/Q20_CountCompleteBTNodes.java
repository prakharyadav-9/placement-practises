package com.py.sheet.binarytree.questions;

import java.util.LinkedList;
import java.util.Queue;

public class Q20_CountCompleteBTNodes {
    public static 
    void main(String...args){
        Node root;
        root = new Node(1);
        
        root.left = new Node(2);
        root.right = new Node(3);
        
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        int count;
        count = countNodes(root);
        System.out.println(count);
    }
    public static int countNodes(Node root) {
        // Code here
        if(root==null)  return 0;
        int count = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Node curr = queue.poll();
                if(curr.left!=null){
                    queue.offer(curr.left);
                    if(curr.right!=null)
                        queue.offer(curr.right);
                }
            }
            count+= size;
        }
        return count;
    }
}
