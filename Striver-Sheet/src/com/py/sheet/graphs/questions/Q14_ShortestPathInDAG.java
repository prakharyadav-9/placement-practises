package com.py.sheet.graphs.questions;

import java.util.*;

public class Q14_ShortestPathInDAG {
    public static void main(String[] args) {
        int edges[][]={
            // {6,4,2},
            // {6,5,3},
            // {5,4,1},
            // {4,2,1},
            // {4,0,3},
            // {0,1,2},
            // {2,3,3},
            // {1,3,1}, // N=7
            // {0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}, // N= 6
            {0,1,2},{0,2,1}
        };
        int n=4,m=edges.length;
        Q14_ShortestPathInDAG obj = new Q14_ShortestPathInDAG();
        int res[] = obj.shortestPath(n,m,edges);
        System.out.println(Arrays.toString(res));
    }
    private final int INF=Integer.MAX_VALUE;
    private class Pair{
        int neighbourNode,cost;
        Pair(int n,int c){
            this.neighbourNode=n;
            this.cost=c;
        }
        public String toString(){
            return "{"+neighbourNode+","+cost+"}";
        }
    }
	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		// step 0 create the adjascancy list of graph
		ArrayList<Pair>[] adjList=new ArrayList[N];
		for(int edge[]:edges){
		    if(adjList[edge[0]]==null){
		        adjList[edge[0]]=new ArrayList<>();
		    }
		    adjList[edge[0]].add(new Pair(edge[1],edge[2]));
		} // graphs is constructed with the adjascent nodes of null
        boolean vist[] = new boolean[N];
        Stack<Integer> st=new Stack<>();
        // step one do a topo sort
        for(int i=0;i<N;i++){
            if(vist[i]==false)
                dfsTopo(i,vist,adjList,st);
        }
        int distance[] =new int[N],src=0;
        Arrays.fill(distance,INF);
        distance[src]=0; // src node always has distance of 0
        // now stack contains the one of possible topological sort
        // time ot take out the shortest distance array
        while(st.isEmpty()==false){
            int topNode=st.pop();
            if(distance[topNode]!=INF && adjList[topNode]!=null){
                for(Pair neighbour: adjList[topNode]){
                    distance[neighbour.neighbourNode] = 
                        Math.min(distance[neighbour.neighbourNode],distance[topNode]+neighbour.cost);
                }
            }else if( distance[topNode]==INF){
                distance[topNode]=-1;
            }
        }
        // replacing the infinte distance with question asked -1
        // for(int i=0;i<N;i++)
        //     if(distance[i]==INF)
        //         distance[i]=-1;
        return distance;
	}
	
	
	private void dfsTopo(int node,boolean vist[],ArrayList<Pair>[] adjList,Stack<Integer>st){
	    vist[node]=true;
	    if(adjList[node]!=null){
	        for(Pair neighbour:adjList[node]){
	            if(vist[neighbour.neighbourNode]==false){
	                dfsTopo(neighbour.neighbourNode,vist,adjList,st);
	            }
	        }
	    }
	    st.push(node);
	}
}
