package dsa.com.py.Blind75.T_06Tree;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Q01_MaxWidth {
    // TreeNode class definition
    public static class TreeNode {
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
    
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        long maxWidth = 0;
        
        // Queue to store (node, position) pairs
        Queue<Pair<TreeNode, Long>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0L));
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            long leftMost = -1;
            long rightMost = -1;
            
            // Process all nodes at current level
            for (int i = 0; i < levelSize; i++) {
                Pair<TreeNode, Long> pair = queue.poll();
                TreeNode node = pair.getKey();
                long position = pair.getValue();
                
                if (leftMost == -1) {
                    leftMost = position;
                }
                rightMost = position;
                
                // Add children with their positions
                if (node.left != null) {
                    queue.offer(new Pair<>(node.left, 2 * position));
                }
                if (node.right != null) {
                    queue.offer(new Pair<>(node.right, 2 * position + 1));
                }
            }
            
            // Calculate width for this level
            long currentWidth = rightMost - leftMost + 1;
            maxWidth = Math.max(maxWidth, currentWidth);
        }
        
        return (int) maxWidth;
    }
    
    // Helper class to store key-value pairs (since we can't use AbstractMap.SimpleEntry in standard imports)
    private static class Pair<K, V> {
        private K key;
        private V value;
        
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        
        public K getKey() {
            return key;
        }
        
        public V getValue() {
            return value;
        }
    }
}
