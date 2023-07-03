package com.py.sheet.graphs.questions;

import java.util.ArrayList;

public class Q03_NumComponents {

    
    private static
    void dfs(int currNode, ArrayList<ArrayList<Integer>> adj,
                boolean visited[]){
        visited[currNode]=true;
        ArrayList<Integer> neighbours = adj.get(currNode);
        for(int neighbour : neighbours){
            if(visited[neighbour]==false){
                dfs(neighbour,adj,visited);
            }
        }
    }
    /*
     * given adj -> Adjancy Matrix
     *       V   -> Number of vertices
     */
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        int proviences = 0;
        // make adjacency list
        ArrayList<ArrayList<Integer>> adjLst = convertAdjMatixToAdjList(
            adj,V); // this makes the adjList of 0 based Indexing
        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                proviences++;
                dfs(i,adjLst,visited); // || BFS both would work
            }
        }
        return proviences;
    }
    
    private static 
    ArrayList<ArrayList<Integer>> convertAdjMatixToAdjList(ArrayList<ArrayList<Integer>> adj, int V){
        ArrayList<ArrayList<Integer>> adjLst = new 
                    ArrayList<>();
        for(int i=0;i<V;i++){
            adjLst.add(i,new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(adj.get(i).get(j)==1&&i!=j){
                    adjLst.get(i).add(j);
                    adjLst.get(j).add(i);
                }
            }
        }   
        return adjLst;
    }
}
