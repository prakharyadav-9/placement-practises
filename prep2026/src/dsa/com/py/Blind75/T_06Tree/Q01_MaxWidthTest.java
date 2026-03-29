package dsa.com.py.Blind75.T_06Tree;

import dsa.com.py.Blind75.T_06Tree.Q01_MaxWidth.TreeNode;

public class Q01_MaxWidthTest {
    public static void main(String[] args) {
        Q01_MaxWidth solution = new Q01_MaxWidth();
        
        System.out.println("=== Testing Maximum Width of Binary Tree ===\n");
        
        // Example 1: root = [1,3,2,5,3,null,9]
        // Expected output: 4 (level 2 has [5,3,null,9])
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);
        root1.left.right = new TreeNode(3);
        root1.right.right = new TreeNode(9);
        
        int result1 = solution.widthOfBinaryTree(root1);
        System.out.println("Example 1:");
        System.out.println("Tree: [1,3,2,5,3,null,9]");
        System.out.println("Expected: 4");
        System.out.println("Got: " + result1);
        System.out.println("Status: " + (result1 == 4 ? "✓ PASSED" : "✗ FAILED"));
        System.out.println();
        
        // Example 2: root = [1,3,2,5,null,null,9,6,null,7]
        // Expected output: 7 (level 3 has [6,null,null,null,null,null,7])
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(5);
        root2.right.right = new TreeNode(9);
        root2.left.left.left = new TreeNode(6);
        root2.right.right.left = new TreeNode(7);
        
        int result2 = solution.widthOfBinaryTree(root2);
        System.out.println("Example 2:");
        System.out.println("Tree: [1,3,2,5,null,null,9,6,null,7]");
        System.out.println("Expected: 7");
        System.out.println("Got: " + result2);
        System.out.println("Status: " + (result2 == 7 ? "✓ PASSED" : "✗ FAILED"));
        System.out.println();
        
        // Example 3: root = [1,3,2,5]
        // Expected output: 2 (level 1 has [3,2])
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(3);
        root3.right = new TreeNode(2);
        root3.left.left = new TreeNode(5);
        
        int result3 = solution.widthOfBinaryTree(root3);
        System.out.println("Example 3:");
        System.out.println("Tree: [1,3,2,5]");
        System.out.println("Expected: 2");
        System.out.println("Got: " + result3);
        System.out.println("Status: " + (result3 == 2 ? "✓ PASSED" : "✗ FAILED"));
        System.out.println();
        
        // Additional test: Single node
        TreeNode root4 = new TreeNode(1);
        int result4 = solution.widthOfBinaryTree(root4);
        System.out.println("Additional Test - Single Node:");
        System.out.println("Tree: [1]");
        System.out.println("Expected: 1");
        System.out.println("Got: " + result4);
        System.out.println("Status: " + (result4 == 1 ? "✓ PASSED" : "✗ FAILED"));
        System.out.println();
        
        // Additional test: Empty tree (null root)
        int result5 = solution.widthOfBinaryTree(null);
        System.out.println("Additional Test - Empty Tree:");
        System.out.println("Tree: null");
        System.out.println("Expected: 0");
        System.out.println("Got: " + result5);
        System.out.println("Status: " + (result5 == 0 ? "✓ PASSED" : "✗ FAILED"));
    }
}
