package com.py.practise.postps.leetcode.potd.M01;

import java.util.ArrayList;
import com.py.practise.postps.leetcode.tree.TreeNode;

public class POTD24_01_09 {
    /*
     * URL: https://leetcode.com/problems/leaf-similar-trees/submissions/?envType=daily-question&envId=2024-01-09 
     * 
     * leaf value sequence - all the leaf nodes from left to right form a sequence
     * 
     * given two roots of the Binary tree, check if they posess equal leaf value sequence
     */

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> leafs1 = getAllLeafs(root1);
        ArrayList<Integer> leafs2 = getAllLeafs(root2);
        return leafs1.equals(leafs2);
    }

    private ArrayList<Integer> getAllLeafs(TreeNode node){
        ArrayList<Integer> leafs = new ArrayList<>();
        getAllLeafs(node,leafs);
        return leafs;
    }
    private void getAllLeafs(TreeNode node, ArrayList<Integer> leafs){
        if(null==node) return;
        if(null ==  node.left && null  == node.right){
            leafs.add(node.val);
        }
        // call left subtree
        getAllLeafs(node.left,leafs);
        // call for right subtree
        getAllLeafs(node.right,leafs);
    }
}
