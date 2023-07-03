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
    }
}
