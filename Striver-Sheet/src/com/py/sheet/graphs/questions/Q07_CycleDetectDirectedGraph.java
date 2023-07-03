package com.py.sheet.graphs.questions;

import java.util.ArrayList;

import com.py.sheet.graphs.Graph;

public class Q07_CycleDetectDirectedGraph {
    public static void main(String...args){
        int[][] cons = {
            {1},
            {2},
            {3},
            {4},
            {}
            // {}, {2}, {1, 3}, {2}
        };
        int v=cons.length;
        ArrayList<ArrayList<Integer>> adj= Graph.makeGraph(v,cons);
        // Graph.printList(adj);
        Q07_CycleDetectDirectedGraph obj = new Q07_CycleDetectDirectedGraph();
        boolean isCyclic = obj.isCyclic(cons.length,adj);
        System.out.println(isCyclic);
    }
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int visited[] = new int[V];
        // 0 not visited
        // 1 visted
        // 2 visited and same path
        for(int i=0;i<V;i++){
            if(visited[i]==0)
                if(dfsCheck(i,adj,visited))
                    return true;
        }
        return false;
    }
    private 
    boolean dfsCheck(int src, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        visited[src]=2;
        // traverse all neighbours
        ArrayList<Integer> neighbours = adj.get(src);
        for(int neighbour: neighbours){
            if(visited[neighbour]==0){
                if(dfsCheck(neighbour, adj, visited))
                    return true;
            }else if(visited[neighbour]==2)
                return true;
        }
        visited[src]=1;
        return false;
    }
}
