package com.py.tests.samsung;

import com.py.sheet.tree.binarytree.questions.Node;
import java.util.*;

public class Q1_BTSumOfKDistanceNodes {
    /**
     * Given a binary Tree head, a distance k and a data n
     *  print all the sum of all nodes at k distance from the nth Node
     *
     */

     public static void main(String []args){
        /*
         *         5
         *      4      3
         *    7   8  N   10
         *  1  N  N     9   2
         */
        Node head = new Node(5),t;
        head.left =t= new Node(4);
        t.left=new Node(7);
        t.right = new Node(8);
        t.left.left = new Node(1);
        head.right =t= new Node(3);
        t=t.right=new Node(10);
        t.left= new Node(9);
        t.right = new Node(2);

        // printInorder(head);
        int sum = -1;
        int k=6, n=1;
        sum = SumOfKDistantNodes(head, k, n);
        System.out.println(sum);
     }

    private static void printInorder(Node head){
        if(head == null) return;
        if(head.left!=null) printInorder(head.left);
        System.out.print(head.data+ " ");
        if(head.right!=null)
            printInorder(head.right);
    }
    private static class TNode_Sum{
        Node target;
        int sum ;
        @Override
        public String toString(){
            return "["+(null!=target?target.data:-1)+" | "+sum+"]";
        }
    }
    public static int SumOfKDistantNodes(Node head,int k, int n){
        Map<Node, Node> pMap = new HashMap<>();
        pMap.put(head,null);
        TNode_Sum ts  = new TNode_Sum();
        getTargetMkMap(head,n,ts,pMap);
        if(ts.target == null) return -1;
        Set<Node> vis = new HashSet<>();
        sumKDistantNodes(ts.target, k, 0,ts,pMap,vis);
        return ts.sum==0?-1:ts.sum;
    }
    private static void getTargetMkMap(Node node, int n,TNode_Sum ts,Map<Node,Node> pMap){
        if(node == null)    return ;
        if(node.data==n) ts.target = node;
        if(node.left !=null){
            pMap.put(node.left,node);
            getTargetMkMap(node.left,n , ts,pMap);
        }
        if(node.right !=null){
            pMap.put(node.right,node);
            getTargetMkMap(node.right,n , ts,pMap);
        }
    }
    private static void sumKDistantNodes(Node node, int k, int level, 
                                        TNode_Sum ts,Map<Node, Node> pMap, Set<Node> vis){
        if(node == null  || vis.contains(node)) return ;
        vis.add(node);
        if(level==k) ts.sum +=node.data;
        if(level<k){
            // System.out.println(node.data);
            sumKDistantNodes(node.left, k, 1+level, ts,pMap,vis);
            sumKDistantNodes(pMap.get(node), k, 1+level, ts, pMap,vis);
            sumKDistantNodes(node.right, k, 1+level, ts, pMap,vis);
        }
    }
}
