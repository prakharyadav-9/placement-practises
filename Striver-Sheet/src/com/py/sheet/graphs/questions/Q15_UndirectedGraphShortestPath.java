package com.py.sheet.graphs.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q15_UndirectedGraphShortestPath {
    // custom made according to the question
    private ArrayList<Integer>[] getAdjList(int edges[][],int V){
        ArrayList<Integer>[]adjList=new ArrayList[V];
        for(int edge[]:edges){
            if(adjList[edge[0]]==null){
                adjList[edge[0]]=new ArrayList<>();
            }
            if(adjList[edge[1]]==null){
                adjList[edge[1]]=new ArrayList<>();
            }
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        return adjList;
    }
    private final int INF=Integer.MAX_VALUE;
    private class Pair{
        int node,dist;
        Pair(int node,int dist){
            this.node=node; this.dist=dist;
        }
    }
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        boolean vist[] =new boolean[n];
        ArrayList<Integer>[]adjList=getAdjList(edges,n);// got proper adjlist
        int dist[]=new int[n];
        Arrays.fill(dist,INF);
        // System.out.println(Arrays.toString(adjList));
        Queue<Pair>q=new LinkedList<>(); // will be using BFS algorithm
        q.offer(new Pair(src,0));
        vist[src]=true;
        while(q.isEmpty()==false){
            Pair p=q.poll();
            dist[p.node]= p.dist;
            ArrayList<Integer>neighbours=adjList[p.node];
            if(neighbours!=null)
            for(int neighbour:neighbours){
                if(vist[neighbour]==false){
                    q.offer(new Pair(neighbour,p.dist+1));
                    vist[neighbour]=true;
                }
            }
        }
        for(int i=0;i<n;i++) if(dist[i]==INF) dist[i]=-1;// fill INF with -1
        return dist;
    }
}
