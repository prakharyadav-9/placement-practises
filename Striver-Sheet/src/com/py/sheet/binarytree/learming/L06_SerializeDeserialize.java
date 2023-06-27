package com.py.sheet.binarytree.learming;

import com.py.sheet.binarytree.questions.Node;
import java.util.*;

public class L06_SerializeDeserialize {
    private static final int EMPTY = -1;//-Integer.MAX_VALUE;
    
    private static void printPreOrder(Node node){
        if(node==null){  System.out.print(EMPTY+" "); return;}
        System.out.print(node.data+ " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    public static void 
    main(String  args[]){
        // tree->
        Node root;
        root = new Node(1);
        
        root.left = new Node(2);
        root.right = new Node(3);
        
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        List<Integer> serialized = null;
        serialized =new ArrayList<Integer>();
        serialize(root,serialized);
        System.out.print("preorder=> ");
        printPreOrder(root);
        System.out.println();
        System.out.println("serialized=> "+serialized);
        Node constRoot = deserialize(serialized);
        System.out.print("deserialized => ");
        printPreOrder(constRoot);
        System.out.println();

        /*
         * stack implementation doesn't work
         */
        // Node stConstRoot = deserilalizedUsingStack(serialized);
        // System.out.println();
        // printPreOrder(stConstRoot);
        // System.out.println();

    }
    /*
     * but this type of tree require lot of redundent data storage
     */
    // recursive function to serialize the tree
    /*
    * number of items  = number of recursive calls 
    in total we will need 
        n + n +1 size
    */
    static
    void serialize(Node node,List<Integer> serialized){
        if(node== null){
            serialized.add(EMPTY);
            return ;
        }
        // do preorder traversal
        serialized.add(node.data);
        serialize(node.left,serialized);
        serialize(node.right,serialized);
    }
    // we had to maintain a  global varialble to maintain an idx
    static int idxx=0;
    static 
    Node deserialize(List<Integer> serialized){
        Node root =null;
        if(idxx<serialized.size()){
            int val = serialized.get(idxx);
            idxx++;
            if(val == EMPTY) return null;
            root = new Node(val);
            root.left=deserialize(serialized);
            root.right = deserialize(serialized);
        }
        return root;
    } // otherwise we could have just made a stack to do so
    // please note the stack will have the preorder in in top

    static Node deserilalizedUsingStack(List<Integer> arr){
        Collections.reverse(arr);
        Stack<Integer> st = new Stack<Integer>();
        for(int ele:arr){
            st.push(ele);
        }
        System.out.println("\n size -> "+ st.size());
        Node rt=deserilaize(st);
        System.out.println("\n"+st);
        return rt;
    }
    static public 
    Node deserilaize(Stack<Integer> st){
        Node root=null;
        System.out.println("desr size -> "+ st.size());
        if(st.size()> 0 ){
            int val = st.pop();
            if(val==EMPTY) return root;
            root = new Node(val);
            printPreOrder(root);
            System.out.println();
            root.left = deserilaize(st);
            root.right = deserialize(st);
        }else{
            System.out.println("size zero:: "+st.size());
        }
        // System.out.println("\n=> "+st);
        return root;
    }
}
