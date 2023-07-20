package com.py.sheet.graphs.questions;

import java.util.*;

import com.py.sheet.graphs.Graph;

public abstract class Q08_CheckBipartite {
    public static void 
    main(String args[]){
        int edges[][]={
            {0,1},
            {1,2},
            };
        int v=3;
        ArrayList<ArrayList<Integer>> adj = Graph.makeGraph(v, edges, true);
        Graph.printList(adj);
        int [][]edges1 = {
            {1},
            {0,2},
            {1}
        };
        System.out.println("Graph using all connections->");
        adj=Graph.makeGraph(edges1.length, edges1);
        Graph.printList(adj);
        // all above code is for generating the graph
        Q08_CheckBipartite obj = new Q08_CheckBipartite() {};
        boolean isBipartitie = obj.isBipartite(v, adj);
        System.out.println("our graph is biPartite :: "+isBipartitie);
    }

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj){
        // Code here
        int colored[] = new int[V];
        for(int i=0;i<V;i++){
            // checking from every node
            if(colored[i]==0){
                // 0 indicate its not colored
                if(bfsColoring(i,colored,adj)==false){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean 
    bfsColoring(int src,int []colored,ArrayList<ArrayList<Integer>>adj){
        Queue<Integer> q=new LinkedList<>();
        colored[src]=1; // inital color 
        q.offer(src);
        while(q.isEmpty()==false){
            Integer currNode = q.poll();
            ArrayList<Integer> neighbours=adj.get(currNode);
            for(Integer neighbour:neighbours){
                if(colored[neighbour]==0){
                    // if its not colored assign an opposite color
                    colored[neighbour] = (colored[currNode]==1)?2:1;
                    q.offer(neighbour); // then add it queue
                }else {
                    if(colored[neighbour]==colored[currNode]){
                        // encounted same color adjascent nodes
                        return false; // graph cannot be bipartite
                    }
                }
            }
        }
        return true;
    } 
}
