package com.py.sheet.graphs.questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q13_AlienDictionary {
    public static void
    main(String...args){
        String dic[] = {"baa","abcd","abca","cab","cad"};
        int N =dic.length,k=4;
        Q13_AlienDictionary obj=new Q13_AlienDictionary();
        String order = obj.findOrder(dic,N,k);
        System.out.println(order);
    }
    public String findOrder(String [] dict, int N, int K){
        // Write your code here
        StringBuilder order = new StringBuilder(K);
        ArrayList<Integer> adjLst[] = new ArrayList[K];
        int dependent[] = new int[K]; // 0 -> a, b -> 1,...
        // make the in degree
        int ii=0,jj=1;
        while(jj<N){
            String first=dict[ii], second=dict[jj];
            int fLen=first.length(),sLen=second.length();
            for(int i=0;i<fLen&&i<sLen;i++){
                char fCh=first.charAt(i),sCh=second.charAt(i);
                if(adjLst[fCh-'a']==null){
                    adjLst[fCh-'a'] = new ArrayList<>();
                }
                if(fCh!=sCh){
                    dependent[sCh-'a']++;
                    // make edge
                    adjLst[fCh-'a'].add(sCh-'a');
                    break; // no need to check further
                }
            }
            ii=jj;
            jj++;
        }
        // System.out.println(Arrays.toString(adjLst));
        // System.out.println(Arrays.toString(dependent));
        // now do kahn's traversal
        Queue<Integer> q=new LinkedList<>();
        for(ii=0;ii<K;ii++){
            if(dependent[ii]==0){
                q.offer(ii);
            }
        } 
        while(q.isEmpty()==false){
            int node = q.poll();
            order.append((char)('a'+node)); // add to answer
            for(int neighbour:adjLst[node] ){
                dependent[neighbour]--;
                if(dependent[neighbour]==0){
                    q.offer(neighbour);
                }
            }
        }
        return order.toString();
    }
}
