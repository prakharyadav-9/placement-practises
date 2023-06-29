package com.py.sheet.tree.binarytree.questions;

public class Q07_MaxSumPath {
    
    public static void
    main(String ...args){
        /*
         *      10
         *     /  \
         *    20   30 
         *   /  \  / 
         *  40 70 60 
         *          \
         *          90
         * 
         */

        Node root=new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.right = new Node(70);
        root.left.left = new Node(40);
        root.right.left = new Node(60);
        root.right.left.right = new Node(90);
        int maxWidth = -1;
        maxWidth =findMaxSum(root);
        System.out.println(maxWidth);
        /*
         *     10
         *    /  \
         *   2   -25
         *  / \  /  \
         * 20 1  3  4
         */
        root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(-25);
        root.left.left = new Node(20);
        root.left.right = new Node(1);
        root.right.left = new Node(3);
        root.right.right = new Node(4);
        maxWidth = findMaxSum(root);
        System.out.println(maxWidth);
    }

    static int sum= (int) -1e9;
    static
    int findMaxSum(Node node){
        //your code goes here
        // int sum = (int) -1e09;
        sum=(int) -1e9;
        System.out.println("Output of f:: "+f(node));
        return sum;
    }
    private static
    int f(Node node){
        if(node==null)  return 0; // baseCase
        int leftMaximum = f(node.left);
        int rightMaximum = f(node.right);
        sum = Math.max(sum, leftMaximum+rightMaximum+node.data);
        System.out.println("updated sum = "+sum);
        return Math.max(0, node.data+Math.max(leftMaximum,rightMaximum));
    }
}
