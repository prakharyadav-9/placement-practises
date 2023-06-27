package com.py.sheet.binarytree.questions;
import java.util.*;
public class Q19_BurningBT {
    
    public static void main(String...args){
        Node root=new Node(1);
        int target;
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(8);
        
        root.right = new Node(3);
        root.right.right = new Node(6);
        root.right.right.right  = new Node(9);
        root.right.right.right.right = new Node(10);
        int time =-1;
        target = 8;
        // example 2
        root = new Node(1);
        root.right = new Node(15);
        root.right.right = new Node(26);
        root.right.right.right = new Node(31);
        root.right.left = new Node(13);
        root.right.left.right = new Node(14);
        root.right.left.left = new Node(3);
        root.right.left.left.right= new Node(4);
        root.right.left.left.left = new Node(2);
        target = 4;
        time = minTime(root,target);
        System.out.println(time);
    }
    public static int minTime(Node root, int target) {
        // Your code goes here
        int time =0;
        // make parent map and get the reference to its target node
        Map<Node,Node> pMap = new HashMap<>();
        Node targetNode = getTargetMap(root,pMap,target);
        time = burningNodes(targetNode,pMap);
        return time;
    }

    private static
    Node getTargetMap(Node root,Map<Node,Node> pMap,int target){
        Node targetNode = null;
        // traverse every node in BFS manner and get its parent into map
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(queue.isEmpty() == false){
            Node curr= queue.poll();
            if(curr.data==target)   targetNode = curr;
            if(curr.left!=null) {pMap.put(curr.left,curr); queue.offer(curr.left);}
            if(curr.right!=null) { pMap.put(curr.right,curr); queue.offer(curr.right);}
        }
        return targetNode;
    }
    private static
    int burningNodes(Node targetNode,Map<Node,Node> pMap){
        int time=0;
        Set<Node> burned = new HashSet<>();
        burned.add(targetNode);
        // bfs traversal for burning
        Queue<Node> queue = new LinkedList<>();
        queue.add(targetNode);
        while(!queue.isEmpty()){
            boolean burn=false; // isSomethingBurned?
            int currQueueSize= queue.size();
            for(int i=0;i<currQueueSize;i++){
                // get front of queue                
                Node curr = queue.poll();
                // check left if burned
                if(curr.left!=null && burned.contains(curr.left)==false){
                    burn=true; 
                    burned.add(curr.left);
                    queue.offer(curr.left);
                }
                // checking right if burned
                if(curr.right!=null && !burned.contains(curr.right)){
                    burn=true;
                    burned.add(curr.right);
                    queue.offer(curr.right);
                }
                // checking the parent
                Node parent = pMap.get(curr);
                if(parent!=null && !burned.contains(parent)){
                    burn = true;
                    burned.add(parent);
                    queue.offer(parent);
                }
            }
            if(burn) time++;
        }
        return time;
    }
}
