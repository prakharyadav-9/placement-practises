package com.py.sheet.tree.binarytree.questions;

import java.util.*;

public class Q12_VerticalOrderTraversal {
    
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
        ans = verticalOrder(root);
        System.out.println(ans);
        System.out.println();
    }

    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(Node root){
        // add your code here
        // final answer
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null)  return ans;
        // Queue containing every entry of Map
        Queue<Map.Entry<Node,Integer>> q = new LinkedList<>();
        // map contains vertical order root at 0, left tree going negative & positive otherwise
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        // adding first entry to the queue
        q.add(Map.entry(root, 0));
        // now we need to do level order traversal
        while(q.isEmpty()==false){
            Map.Entry<Node,Integer> currEntry = q.poll();
            Node currNode= currEntry.getKey();
            int currLevel =  currEntry.getValue();
            //getting the existing ArrayList or creating a new 
            ArrayList<Integer> levelList = map.getOrDefault(currLevel,new ArrayList<>());
            // adding the element to list
            levelList.add(currNode.data);
            // putting back the list
            map.put(currLevel,levelList);
            // going for next level
            if(currNode.left!=null) q.add(Map.entry(currNode.left,currLevel-1)); 
            if(currNode.right!=null) q.add(Map.entry(currNode.right,currLevel +1));
        }
        // now the map would contain every Vertical level and its level order entry
        for(Map.Entry<Integer,ArrayList<Integer>> vLevels : map.entrySet()){
            ans.addAll(vLevels.getValue());
        }
        return ans;
    }
}
