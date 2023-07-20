package com.py.sheet.graphs.questions;

import java.util.*;

class Q11_DFSTopologicalSort{
    /*
     * Topological sort only happens to DAG
     */
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // add your code here
        Stack<Integer> st=new Stack<>();
        boolean visited[] = new boolean[V];
        int result[] = new int [V],i=0;
        for(i=0;i<V;i++){
            if(visited[i]==false){
                dfsTopo(i,visited,adj,st);
            }
        } // now st contains any topo sort in reverse order
        i=0;
        while(st.isEmpty()==false){
            result[i++]=st.pop();
        }
        return result;
    }
    private static void dfsTopo(int node,boolean visited[]
                ,ArrayList<ArrayList<Integer>> adj,Stack<Integer> st){
        visited[node]=true;              
        ArrayList<Integer> neighbours=adj.get(node);
        for(int neighbour:neighbours){
            if(!visited[neighbour]){
                dfsTopo(neighbour,visited,adj,st);
            }
        }
        st.push(node); // after all exploration from the node put into stack
    }
}