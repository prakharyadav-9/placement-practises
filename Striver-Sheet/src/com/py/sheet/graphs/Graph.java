package com.py.sheet.graphs;

import java.util.*;

public class Graph {
    public static ArrayList<ArrayList<Integer>> makeGraph(int v,int e,int connections[][]){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v+1);
        for(int i=0;i<connections.length;i++){
            ArrayList<Integer> neighbours = new ArrayList<>();
            for( int ele:connections[i]){
                neighbours.add(ele);
            }
            adj.add(i,neighbours);
        }
        return adj;
    }

    public static void printList(ArrayList<ArrayList<Integer>> adj){
        for(ArrayList<Integer> nodes:adj){
            System.out.print("[");
            for(int ele:nodes)  System.out.printf("%d ",ele);
            System.out.print("]");
            System.out.println();
        }
    }
}
