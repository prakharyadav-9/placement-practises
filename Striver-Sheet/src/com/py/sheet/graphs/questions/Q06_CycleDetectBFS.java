package com.py.sheet.graphs.questions;

import java.util.*;

import com.py.sheet.graphs.Graph;

public class Q06_CycleDetectBFS {
    public static void main(String...args){
        int v=0;
        int e=0;
        int[][] cons = {
            // {1},
            // {0,2,4},
            // {1,3},
            // {2,4},
            // {1,3},
            {}, {2}, {1, 3}, {2}
        };
        ArrayList<ArrayList<Integer>> adj= Graph.makeGraph(v, e, cons);
        // Graph.printList(adj);
        Q06_CycleDetectBFS obj = new Q06_CycleDetectBFS();
        boolean isCyclic = obj.isCycle(cons.length,adj);
        System.out.println(isCyclic);
    }


    private 
    boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vst[] =new boolean[V];
        for(int i=0;i<V;i++)
            if(!vst[i]){
                if(bfs(i,adj,vst))
                    return true;
            }
        return false;
    }

    private class Pair{
        int node,parent;
        Pair(int node, int parent){
            this.node=node; // current node
            this.parent=parent; // holds calling parent node
        }
    }

    private 
    boolean bfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vst) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(src,-1));
        while(!q.isEmpty()){
            Pair node = q.poll();
            vst[node.node] = true; // mark the node
            ArrayList<Integer> neighbours = adj.get(node.node);
            // System.out.printf("%d->",node.node);
            for(Integer neighbour:neighbours){  
                if(neighbour!=node.parent){
                    if(vst[neighbour])
                        return true;
                    q.offer(new Pair(neighbour,node.node));
                }
            }
        }
        // System.out.println();
        return false;
    }
}
