package com.py.sheet.graphs.questions;

import java.util.ArrayList;

public class Q02_DFSGraph {

    /*
     * DFS recurssive approach
     */
    private boolean visited[];
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V,
                                    ArrayList<ArrayList<Integer>> adj) {
        // Code here
        visited = new boolean[V];
        int start =0;
        ArrayList<Integer> res = new ArrayList<>();
        traverse(start,adj,res);
        return res;
    }
    private void
    traverse(int currIdx, 
                        ArrayList<ArrayList<Integer>> adj,
                                                ArrayList<Integer> res){
        res.add(currIdx);
        this.visited[currIdx] = true;
        ArrayList<Integer> neighbours = adj.get(currIdx); 
        for(int neighbour:neighbours){
            if(!this.visited[neighbour]){
                traverse(neighbour,adj,res);
            }
        }
    }
}
