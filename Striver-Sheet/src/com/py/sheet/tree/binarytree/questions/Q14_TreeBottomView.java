package com.py.sheet.tree.binarytree.questions;

import java.util.*;

public class Q14_TreeBottomView {
    /*
     *      root = 10
     *      /       \
     *      20      30
     *      /\      /
     *     40 70    60
     *                \ 
     *                  90
     * 
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
        /*
         *              2
         *             / \
         *            1   10
         *               /
         *              3
         *               \
         *                6
         *              /   \
         *             4     9
         *              \
         *              5
         */
        // root = new Node(2);
        // root.left = new Node(1);
        // root.right = new Node(10);
        // root.right.left = new Node(3);
        // root.right.left.right = new Node(6);
        // root.right.left.right.left = new Node(4);
        // root.right.left.right.right = new Node(9);
        // root.right.left.right.left.right = new Node(5);
        ans = bottomView(root);
        System.out.println(ans);
        System.out.println();
    }
    static ArrayList<Integer> bottomView(Node root){
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
            map.put(currLevel,currNode.data);
            if(currNode.left!=null) q.add(Map.entry(currNode.left,currLevel-1));
            if(currNode.right!=null)q.add(Map.entry(currNode.right,currLevel+1));
        }
        for(Map.Entry<Integer,Integer> views:map.entrySet()){
            ans.add(views.getValue());
        }
        return ans;
    }
}
