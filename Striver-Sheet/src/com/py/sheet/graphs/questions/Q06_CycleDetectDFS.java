package com.py.sheet.graphs.questions;

import java.util.*;

import com.py.sheet.graphs.Graph;

public class Q06_CycleDetectDFS {
    public static void main(String...args){
        int v=0;
        int e=0;
        int[][] cons = {
            {1},
            {0,2,4},
            {1,3},
            {2,4},
            {1,3},
            // {}, {2}, {1, 3}, {2}
        };
        ArrayList<ArrayList<Integer>> adj= Graph.makeGraph(v, e, cons);
        // Graph.printList(adj);
        Q06_CycleDetectDFS obj = new Q06_CycleDetectDFS();
        boolean isCyclic = obj.isCycle(cons.length,adj);
        System.out.println(isCyclic);
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vist[] = new boolean[V];
        for(int i=0;i<V;i++){ // checking all possible nodes
            if(!vist[i]){ // which are not visited
                if(dfs(i,vist,adj)){ // if there is a cycle
                    return true;
                }
            }   
        }
        return false; // else no cycle present
    }
    private class Pair{
        int node,parent;
        Pair(int node, int parent){
            this.node=node; // current node
            this.parent=parent; // holds calling parent node
        }
    }
    private boolean dfs(int src, boolean vst[]
                ,ArrayList<ArrayList<Integer>> adj)    {
        
        Stack<Pair> st=new Stack<>(); // stack to maintain the calling order
        st.push(new Pair(src, -1)); // the source would have no parent
        while(st.isEmpty()==false){
            Pair top = st.pop();
            vst[top.node]=true;
            // System.out.printf("%d->",top.node);
            Iterator<Integer> it = adj.get(top.node).iterator();
            while(it.hasNext()){
                int nighbour=it.next();
                if(nighbour!=top.parent){ // parent ---- neighbour is not cycle
                    if(vst[nighbour])  
                        return true; // got a node already visted once hence cycle
                    st.push(new Pair(nighbour,top.node)); // pushing every new neighbour
                }
            }
        }
       return false; // no cycle detected
    }
}
