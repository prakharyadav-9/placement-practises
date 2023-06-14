package com.py.sheet.binarytree.questions;

import java.util.*;

public class Q13_TreeTopView {
    
    /*
     *      root = 10
     *      /       \
     *      20      30
     *      /\      /
     *     40 70    60
     *                \ 
     *                  90
     * 
     * output :-
     * 10
     * 20 30
     * 40 70 60
     * 90
     */
    public static 
    void main(String...args){
        Node root=new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(70);
        root.right.left = new Node(60);
        root.right.left.right = new Node(90);
        List<Integer> ans = null;
        root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(10);
        root.right.left = new Node(3);
        root.right.left.right = new Node(6);
        root.right.left.right.left = new Node(4);
        root.right.left.right.right = new Node(9);
        root.right.left.right.left.right = new Node(5);
        ans = topView(root);
        System.out.println(ans);
        System.out.println();
    }

    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root){
        // add your code
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Queue<Map.Entry<Node,Integer>> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        q.add(Map.entry(root,0));
        while(q.isEmpty()==false){
            Map.Entry<Node,Integer> currEntry = q.poll();
            Node currNode = currEntry.getKey();
            int currLevel = currEntry.getValue();
            if(!map.containsKey(currLevel))
            {
                map.put(currLevel,currNode.data);
                // ans.add(currNode.data);
            }
            if(currNode.left!=null) q.add(Map.entry(currNode.left,currLevel-1));
            if(currNode.right!=null)q.add(Map.entry(currNode.right,currLevel+1));
        }
        for(Map.Entry<Integer,Integer> views:map.entrySet()){
            ans.add(views.getValue());
        }
        return ans;
    }

}
