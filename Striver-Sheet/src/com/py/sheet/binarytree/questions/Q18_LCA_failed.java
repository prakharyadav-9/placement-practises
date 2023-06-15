package com.py.sheet.binarytree.questions;
import java.util.*;
public class Q18_LCA_failed {
    
    public static void 
    main(String...args){
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
        int n1=7;
        int n2=11;
        root =  new Node(7);
        root.left = new Node(1);
        root.right = new Node(10);
        root.left.right =new Node(4);
        root.right.right =new Node(11);
        root.right.right.right = new Node(12);
        root.right.left=new Node(9);
        root.right.left.left = new Node(8);

        root = new Node(5);
        root.left = new Node(1);
        root.right =  new Node(9);
        root.left.right=new Node(4);
        root.right.left = new Node(7);
        Node lca = null;
        n1=9;
        n2 = 4;
        lca =lca(root,n1,n2);
        System.out.println("in main => lca.data = "+lca.data);
    }

    static Node t1=null;
    static Node t2=null;
    static boolean flag = true;
    static Node ancestorNode=null;
    private static Node lca(Node root, int n1, int n2) {
        // step 1 find target node and make parent simantanously 
        Map<Node,Node> pMap = new HashMap<>();
        makeParentsMap(root,pMap,n1,n2);
        // System.out.println("Parent Map made"+ pMap);
        System.out.println("firstNode discoverd was ::"+ ancestorNode.data);
        System.out.println(" t1 = "+t1.data+ " t2 = "+t2.data);
        Node lca = null;
        // searching with first anscestor Node
        lca = ancestorSearch(ancestorNode, ancestorNode==t1?t2:t1,pMap);
        
        lca=(lca!=null?lca:findLCA(t1,t2,pMap));
        // System.out.println("lca.data = "+lca.data);
        return lca;
    }
    private static Node ancestorSearch(Node ancestorNode2, Node node, Map<Node, Node> pMap) {
        if(ancestorNode2==node){
            return node;
        }
        // else
        Node nodesParent = pMap.get(node);
        return nodesParent!=null?ancestorSearch(ancestorNode2, nodesParent, pMap):null;
    }
    private static Node findLCA(Node t12, Node t22, Map<Node, Node> pMap) {
        if(t12.data==t22.data){
            return t12;
        }
        else
            return findLCA(pMap.get(t12),pMap.get(t22),pMap);
    }
    private static void makeParentsMap(Node node, Map<Node, Node> pMap, int n1, int n2) {
        if(node == null)    return;
        if(t1==null || t2==null){
            if(node.data==n1)
                t1= node;
            if(node.data == n2)
                t2=node;
            if(flag && (t1!=null || t2!=null)){
                flag^=true;
                ancestorNode = t1==null?t2:t1;
            }
        }
        if(node.left!=null) {
            pMap.put(node.left,node);
            makeParentsMap(node.left, pMap, n1, n2);
        }
        if(node.right!=null){
            pMap.put(node.right,node);
            makeParentsMap(node.right,pMap, n1, n2);
        }
    }
}
