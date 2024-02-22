package com.py.practise.postps.leetcode.potd.M02;

public class POTD24_02_22{
    /*
    * URL: https://leetcode.com/problems/find-the-town-judge/ 
    *   citezens 1 to n, 
    *   given n = number of citizens
    *   trust[i] = [ai , bi] => ai trusts bi
    *   one could be a judge find the judge with following conditions
    * 1. judge dont trust anyone
    * 2. everybody trust judge
    * 3. there is exactly one person satisfies 1 and 2
    */
    public int findJudge(int n, int[][] trust) {
        long sum = ((n+1)*n)/2;
        Set<Integer>[] citezens = new HashSet[n+1];
        for(int[] relationship:trust){
            if(citezens[relationship[0]] == null){
                citezens[relationship[0]] = new HashSet<Integer>();
                sum-=relationship[0]; // only one time counting
            }
            citezens[relationship[0]].add(relationship[1]);
        }
        int judge = (int)sum;        
        if(judge==0 || judge>n||citezens[judge]!=null)
            return -1;
        for(int i=1;i<n+1;i++){
            if(i==judge)
                continue; // then it would be null
            if(citezens[i].contains(judge)==false){
                return -1;
            }
        }
        return judge;
    }
}