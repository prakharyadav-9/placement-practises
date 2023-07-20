package com.py.sheet.graphs.questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q12_CourseSchedule_I_II {
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) {
        // prepare in degree -> question is easily doable by Kahn's algorithm
        Queue<Integer> q=new LinkedList<>();
        int []indegree= new int[n],ans=new int [n];
        // i need to have an adjascency list
        ArrayList<Integer>[] adjList = new ArrayList[n];
        for(ArrayList<Integer> prereq:prerequisites){
            int from=prereq.get(1),to=prereq.get(0);
            indegree[to]++; // filling in degree
            if(adjList[from]==null){ adjList[from] = new ArrayList<>(); } 
            adjList[from].add(to); // add the neighbour
        }
        // add all who has 0 prerequisite
        for(int i=0;i<n;i++)
            if(indegree[i]==0)
                q.offer(i); // since labeling is 0 based no issue

        int ii=0,check=0;// ii idx for inserting to ans, 
        while(q.isEmpty()==false){
            int task=q.poll();
            ans[ii++]=task;
            check+=1; // check tells how many answers we have added
            if(adjList[task]!=null&&adjList[task].isEmpty()==false){
                ArrayList<Integer> dependents = adjList[task];
                for(int dependent:dependents){
                    indegree[dependent]--;
                    if(indegree[dependent]==0)
                        q.offer(dependent);
                }
            }
        }
        if(n!=check) return new int[0]; // if we have not added all task then impossible
        return ans;
    }
}
