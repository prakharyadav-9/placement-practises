package com.py.practise.postps.leetcode.potd.M01;

public class POTD24_01_08 {
    /*
     * URL: https://leetcode.com/problems/range-sum-of-bst/?envType=daily-question&envId=2024-01-08 
     * 
     * Given the root node of a binary search tree and two integers low and high,
     * return the sum of values of all nodes with a value in the inclusive range [low, high].
     */

     
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
     public int rangeSumBST(TreeNode root, int low, int high) {
        if ( null == root){
            return 0; // a default value for null node
        }
        // if the value is in range
        if(root.val>=low && root.val<=high){
            return root.val   // include the value
                + rangeSumBST(root.left, low, high) // include left subtree
                    + rangeSumBST(root.right,low,high); // include right subtree
        }else if(root.val<low){
            return rangeSumBST(root.right,low,high); // jump to right subtree
        }else{
            return rangeSumBST(root.left,low,high); // else jump to left subtree
        }
    }
}
