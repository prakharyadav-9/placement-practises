package com.py.sheet.binarytree.questions;

import java.util.ArrayList;

public class Q16_AllLeafPaths {
    public static void
    main(String args[]){
        Node root=new Node(10);
        // root.left = new Node(20);
        // root.right = new Node(30);
        // root.left.left = new Node(40);
        // root.left.right = new Node(70);
        // root.right.left = new Node(60);
        // root.right.left.right = new Node(90);
        ArrayList isSymmetric = Paths(root);
        System.out.println(isSymmetric);
    }
    static
    public ArrayList<ArrayList<Integer>> Paths(Node root){
        // Code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        addPaths(root, new ArrayList<>(), res);
        return res;
    }
    private static 
    void addPaths(Node node, ArrayList<Integer> currentPaths,
                             ArrayList<ArrayList<Integer>> res){
        if(node == null) return;
        currentPaths.add(node.data);
        if(isLeaf(node)){
            res.add(new ArrayList<>(currentPaths));
        }
        else
        {
            addPaths(node.left,currentPaths,res);
            addPaths(node.right,currentPaths,res);
        }
        currentPaths.remove(currentPaths.size()-1);
    }
    static
    private boolean isLeaf(Node node){
        return node.left==null&&node.right==null;
    }
}
