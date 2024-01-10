package com.py.practise.postps.leetcode.potd.M01;

import java.util.*;
import com.py.practise.postps.leetcode.tree.TreeNode;

public class POTD24_01_10 {
    /*
     * URL: https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/?envType=daily-question&envId=2024-01-10
     * 
     * given a root of BT and a target, from the target at t=0 the nodes are infecting
     * calculate the time(t) when complete tree is infected
     */

    private Set<TreeNode> allNodes = new HashSet<>();
    private TreeNode t = null;

    private void makeParent(TreeNode node,Map<TreeNode, TreeNode> pmap,int start){
        if(null==node) return;
        allNodes.add(node);
        if(start==node.val) t=node;
        if(null!=node.left) pmap.put(node.left,node);
        if(null!=node.right) pmap.put(node.right,node);
        makeParent(node.left,pmap,start);
        makeParent(node.right,pmap,start);
    }
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode,TreeNode> pmap = new HashMap<>();
        pmap.put(root,null);
        int time = -1;
        Queue<TreeNode> adjNodes = new LinkedList<>();
        makeParent(root,pmap,start);
        
        checkAndAddToQue(t,adjNodes,pmap);
        allNodes.remove(t);
        // adjNodes.offer(t);
        // System.out.println(adjNodes.ssize());
        while(false==adjNodes.isEmpty()){
            time++;
            int sz = adjNodes.size();
            for(int i=0;i<sz;i++){
                TreeNode node = adjNodes.poll();
                checkAndAddToQue(node,adjNodes,pmap);
                allNodes.remove(node);
            }
        }
        return -1==time?0:time;
    }
    private void checkAndAddToQue(TreeNode node, Queue<TreeNode> adjNodes,
                Map<TreeNode,TreeNode> pmap){
        if(allNodes.contains(node)){
            if(null != pmap.get(node)) adjNodes.offer(pmap.get(node));
            if(null != node.left) adjNodes.offer(node.left);
            if(null != node.right)adjNodes.offer(node.right);
        }
    }
}
