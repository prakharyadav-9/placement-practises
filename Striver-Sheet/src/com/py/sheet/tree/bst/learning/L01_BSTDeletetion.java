package com.py.sheet.tree.bst.learning;

import com.py.sheet.tree.Node;
import java.util.*;

public class L01_BSTDeletetion {

    /*
     * This implementation failed  :(
     *  please refer the Q01_BSTDeleteNode.java
     */
    
    public static void main(String args[]){
        int elements[] = {50,30,70,40,60,80};
        Node root=null;
        System.out.println("BST");
        for(int ele:elements){
            // tree construction 
            root=Node.insert(root, ele);
        } 
        // int preOrderArr[] ;
        // preOrderArr = getPreOrderArr(Node.preOrderTraversal(root), "\\[->\"\"","]->\"\"");
        // makeSuccessor(root, preOrderArr);
        System.out.println("Successor making complete");
        // System.out.println("successor of "+root.data+" is " +getSuccessor(root).data);
        String preorder = Node.preOrderTraversal(root);
        System.out.println(preorder);
        Node del = null;
        //deleteBSTNode(root, 50);
        del = delNode(root, 70);
        preorder = Node.preOrderTraversal(del);
        System.out.println(preorder);
    }

    public static Node delNode(Node root, int x){
        if(root==null)
            return root;
            if(root.data>x)
            root.left=delNode(root.left,x);
            else if(root.data<x)
            root.right=delNode(root.right,x);
            else{
                if(root.left==null){
                    return root.right;
                }
                else if(root.right==null){
                    return root.left;
                }
                else{
                int preOrderArr[] = getPreOrderArr(Node.preOrderTraversal(root), "\\[->\"\"","]->\"\"");
                makeSuccessor(root, preOrderArr);
                Node succ=getSuccessor(root);
                root.data=succ.data;
                root.right=delNode(root.right,succ.data);
            }
        }
        return root;
    } 
    static Node deleteBSTNode(Node root,int key){
        if(root==null ) return null;
        if(root.data>key){ // key is probably in left sub-tree
            root.left = deleteBSTNode(root.left, key);
        }   
        else if(root.data<key){  // key is probably in right sub-tree
            root.right=deleteBSTNode(root.right,key);
        }
        else{ // happens only when key is found and her ehandling if key is found condition
            if(root.left==null) return root.right;
            else if(root.right==null ) return root.left;
            else{
                Node successor = getSuccessor(root);
                root.data = successor.data;
                root.right = deleteBSTNode(root.right, successor.data);
            }
        }
        return root;
    }
    /*
     * filters are given 
     *  regex->replacements
     */
    static private
    int[] getPreOrderArr(String preorder,String...filters){

        for(String filter:filters){
            String []temp= filter.split("->");
            String regex = temp[0];
            String replacement = temp[1];
            // System.out.println("replacement=> "+ replacement);
            preorder = preorder.replaceAll(regex, replacement);
        }
        
        preorder = preorder.replaceAll("\"\"", "");
        // System.out.println("preorder-> "+preorder);
        String filtered[] =preorder.split(" ");
        int preOrderArr[] = new int[filtered.length];
        for(int i=0;i<preOrderArr.length;i++){
            preOrderArr[i] = Integer.valueOf(filtered[i]);
        }
        return preOrderArr;
    }
    static
    Node getSuccessor(Node node){
        return successors.get(node);
    }
    static
    Map<Node,Node> successors=new HashMap<>();
    static
    void makeSuccessor(Node root,int arr[]){
        if(root==null || arr==null)  return ;
        // System.out.println("pre order => "+preorder);
        Map<Integer,Node> map = new TreeMap<>();
        // traverse and get the reference of each of node
        Stack<Node> nodeStack = new Stack<>();
        Node t= root;
        while(t!=null || nodeStack.empty()==false){
            while(t!=null){
                nodeStack.push(t);
                t=t.left;
            }
            t=nodeStack.pop();
            // System.out.print(t.data+" ");
            map.put(t.data,t);
            t=t.right;
        }
        // System.out.println();
        for(int i=1;i<arr.length;i++){
            successors.put(map.get(arr[i-1]),map.getOrDefault(arr[i],null));
        }
    }
}
