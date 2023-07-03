package com.py.sheet.graphs;

import java.util.*;

public class Graph {
    /**
     *<p> Makes the Adjascency graph form the connection matrix, all nodes are in ascending order.</p>
     * 
     * 
     * 
     * <p>Note: you need to provide all the neighbours of a node
     *  if you dont provid it makes it as a directed graph </p>
     * @param v : Number of vertices
     * @param connections : conenctions :for each vertices give its connections
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public static ArrayList<ArrayList<Integer>> makeGraph(int v,int connections[][]){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v+1);
        for(int i=0;i<v;i++){
            ArrayList<Integer> neighbours = new ArrayList<>();
            for( int ele:connections[i]){
                neighbours.add(ele);
            }
            Collections.sort(neighbours);
            adj.add(i,neighbours);
        }
        return adj;
    }
    /**
     * Makes a graph with supplied edges for provided vertices
     *  
     * @param v number of vertices
     * @param edges edges of the {src , des} vertices
     * @param isUnDirected if its undirected pass True else for directed False 
     * @return Adjacency list of graph
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public static ArrayList<ArrayList<Integer>> makeGraph(int v,int edges[][],boolean isUnDirected){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v+1);
        for(int i=0;i<v;i++){
            adj.add(i,new ArrayList<>()); // add empty list to all vertices
        }
        for(int edge[]:edges){
            adj.get(edge[0]).add(edge[1]);
            if(isUnDirected){
                adj.get(edge[1]).add(edge[0]);
                Collections.sort(adj.get(edge[1]));
            }
            Collections.sort(adj.get(edge[0]));
        }
        return adj;
    }

    /**
     * Prints the Graph from provided adjascency List
     * @param adj
     * @throws NullPointerException
     */
    public static void printList(ArrayList<ArrayList<Integer>> adj){
        for(ArrayList<Integer> nodes:adj){
            System.out.print("[");
            for(int ele:nodes)  System.out.printf("%d ",ele);
            System.out.print("]");
            System.out.println();
        }
    }
}
