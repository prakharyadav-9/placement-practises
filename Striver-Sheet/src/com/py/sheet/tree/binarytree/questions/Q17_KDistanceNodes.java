package com.py.sheet.tree.binarytree.questions;

import java.util.*;

public class Q17_KDistanceNodes {
    
    public static void main(String...args){
        int target = 6;
        int k=4;
        Node root=new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left= new Node(10);
        root.left.right.right = new Node(14);
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        ArrayList kDistanceNodes = KDistanceNodes(root,target,k);
        System.out.println(kDistanceNodes);

    }
    static Node targetNode=null;
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k){
        // return the sorted list of all nodes at k dist
        ArrayList<Integer> ans = new ArrayList<>();
        // step 1 need a parent map
        Map<Node, Node> parentMap = new HashMap<>(); // key is actual node and value is parent
        buildParentmap(root,parentMap);
        // step 2 make an accessible variable to get the target node
        getTargetNode(root,target);
        // now we have got to find the nodes at K distance
        // keep track of visited nodes
        // System.out.println(" got the target node as ::"+ targetNode.data);
        Set<Node> visited = new HashSet<>();
        findNodesAtK(targetNode, k,ans,parentMap,visited);
        // last step sort the list and return
        Collections.sort(ans);
        return ans;
    }
    private static void
    findNodesAtK(Node node, int distance, ArrayList<Integer> res,Map<Node,Node> map,Set<Node> visitedNodes){
        if(node== null || visitedNodes.contains(node)) return ;
        visitedNodes.add(node);
        if(distance == 0){
            res.add(node.data);
            return;
        }
        if(node.left!=null) findNodesAtK(node.left,distance-1,res,map,visitedNodes);
        if(node.right!=null) findNodesAtK(node.right,distance-1,res,map,visitedNodes);
        // need to find the node upwards as well
        findNodesAtK(map.get(node),distance-1,res,map,visitedNodes);
    }
    private static void getTargetNode(Node node, int target) {
        if(node == null)    return;
        if(node.data == target){
            targetNode = node;
            return ;
        }
        // serach left 
        if(node.left!=null) 
            getTargetNode(node.left,target);
        // search right
        if(node.right!=null)
            getTargetNode(node.right,target);
    }
    private static void 
    buildParentmap(Node node, Map<Node,Node> map){
        if(node == null)    return; // null cannot have a map
        if(node.left!=null){
            map.put(node.left,node);
            buildParentmap(node.left,map);
        }
        if(node.right!=null){
            map.put(node.right,node);
            buildParentmap(node.right,map);
        }
    } 
}
