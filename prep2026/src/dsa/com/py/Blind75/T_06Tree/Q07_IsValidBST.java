package dsa.com.py.Blind75.T_06Tree;

import java.util.Stack;

public class Q07_IsValidBST {
 
 // Definition for a binary tree node.
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
 
class Solution {
    public boolean isValidBST(TreeNode root) {
       long leftRange = Long.MIN_VALUE; // this crosses if the root itself is Integer.MIN_VALUE
       long rightRange = Long.MAX_VALUE; // similarly for Integer.MAX_VALUE
       return isValidBST(root, leftRange, rightRange);
    }

    private boolean isValidBST(TreeNode root, long leftRange, long rightRange){
        if(root == null) return true;
        if(leftRange>=root.val || root.val >= rightRange) return false; 
        return isValidBST(root.left, leftRange, root.val) && isValidBST(root.right, root.val, rightRange);
    }

    public boolean isValidBSTIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode prev = null;
        
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (prev != null && curr.val <= prev.val) return false;
            prev = curr;
            curr = curr.right;
        }
        return true;
    }
}
}
