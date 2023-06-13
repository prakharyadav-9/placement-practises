package com.py.sheet.binarytree.learming;

import java.util.*;

import com.py.sheet.binarytree.questions.Node;

public class L04_PrintKDistanceNodes {
    
    public static 
    void main(String...args){
    /*
     *      root = 10
     *      /       \
     *      20      30
     *      /\      /
     *     40 70    60
     *                \ 
     *                  90
     */
        Node root=new Node(10);
        List<Integer> res=new ArrayList<>();
        int k =4;
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(70);
        root.right.left = new Node(60);
        root.right.left.right = new Node(90);;
        res = printKDistanceNodes(root,k, res);
        System.out.println(res);
    }
    static
    List<Integer> printKDistanceNodes(Node root,int k,List<Integer> res){
        if(root==null){
            return res;
        }
        if(k==0){
            res.add(root.data);
        }
        else{
            printKDistanceNodes(root.left,k-1, res);
            printKDistanceNodes(root.right,k-1, res);
        }
        return res;
    }
}
