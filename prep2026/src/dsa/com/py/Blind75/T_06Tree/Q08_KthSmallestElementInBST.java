package dsa.com.py.Blind75.T_06Tree;

public class Q08_KthSmallestElementInBST {

    // Definition for a binary tree node.
    // This was added to make the file self-contained and runnable.
    class TreeNode {
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
        /**
         * Finds the kth smallest element in a Binary Search Tree using a stateless recursive approach.
         *
         * This version improves upon previous recursive solutions by eliminating all member state.
         * Instead, it uses a single-element integer array (`int[1]`) to simulate a "pass-by-reference" counter.
         *
         * Why use an array? In Java, primitives like 'int' are passed by value. Changes to a counter within
         * a recursive call would not be reflected in the parent calls. By passing an array (which is an object),
         * all recursive calls share the same reference to the array and can modify its contents (e.g., count[0]).
         * This allows the count to be correctly maintained throughout the traversal without using member variables,
         * making the method thread-safe and re-entrant.
         *
         * @param root The root of the BST.
         * @param k    The order of the smallest element to find (1-indexed).
         * @return The value of the kth smallest element, or -1 if k is invalid.
         */
        public int kthSmallest(TreeNode root, int k) {
            // Use a single-element array to simulate a mutable integer passed by reference.
            int[] count = new int[1];
            TreeNode resultNode = inOrderTraversal(root, k, count);
            // As per constraints, k is always valid, but returning -1 is good practice for invalid k.
            return resultNode != null ? resultNode.val : -1;
        }

        /**
         * Performs a recursive in-order traversal to find the kth smallest node.
         *
         * @param node  The current node in the traversal.
         * @param k     The target rank to find.
         * @param count A single-element array acting as a mutable counter across recursive calls.
         * @return The kth smallest TreeNode, or null if not found yet in this subtree.
         */
        private TreeNode inOrderTraversal(TreeNode node, int k, int[] count) {
            // Base case: we've reached the end of a branch.
            if (node == null) {
                return null;
            }

            // 1. Traverse the left subtree.
            // If the node is found on the left, propagate it up the call stack immediately.
            TreeNode found = inOrderTraversal(node.left, k, count);
            if (found != null) {
                return found;
            }

            // 2. Process the current node (after visiting the entire left subtree).
            // Increment the shared counter.
            count[0]++;
            // Check if the current node is the kth one.
            if (count[0] == k) {
                return node;
            }

            // 3. If not found yet, traverse the right subtree.
            return inOrderTraversal(node.right, k, count);
        }
    }

}
