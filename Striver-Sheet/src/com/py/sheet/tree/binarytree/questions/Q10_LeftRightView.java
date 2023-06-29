package com.py.sheet.tree.binarytree.questions;

import java.util.ArrayList;
import java.util.List;

public class Q10_LeftRightView {
    public static void 
    main(String args[]){
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
        List<Integer> ans =null;
        ans = leftView(root);
        System.out.println(ans);
    }
    static int maxLevel = -0; // reached levels
    static
    ArrayList<Integer> leftView(Node root){
      // Your code here
      int level=1;
      ArrayList<Integer> ans = new ArrayList<>();
      return leftRightView(root, ans,level,true); // true indicates left view else right view
    }
    static
    ArrayList<Integer> leftRightView(Node root, ArrayList<Integer> ans, int level,boolean isLeft){
        if(root == null ) return ans;
        if(maxLevel<level){ // new level encountered
            ans.add(root.data);
            maxLevel=level;
        }
        if(isLeft){
            leftRightView(root.left, ans,level+1, isLeft);
            leftRightView(root.right,ans,level+1,isLeft);
        }else{
            leftRightView(root.right, ans, level, isLeft);
            leftRightView(root.left, ans, level, isLeft);
        }
        return ans;
    }
}
