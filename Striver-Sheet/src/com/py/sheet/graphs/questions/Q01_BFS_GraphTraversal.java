package com.py.sheet.graphs.questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q01_BFS_GraphTraversal {
    
    public static void
    main(String args[]){
        
    }

    /*
     * All component traversal
     */
    public ArrayList<Integer> bfsOfGraph(int V,
                    ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int start =0;
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[V]; // V = #vertices
        for(int i=start;i<start+V && !visited[i];i++){
            queue.add(i);
            visited[i]=true;
            while(!queue.isEmpty()){
                int top = queue.remove();
                ans.add(top);
                ArrayList<Integer> currAdj= adj.get(top);
                for(int node:currAdj){
                    if(visited[node]==false){
                        queue.add(node);
                        visited[node]=true;
                    }    
                }
            }
            
        }
        return ans;
    }
}
