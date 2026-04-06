package dsa.com.py.A2Z.T_01GreedyAlgorithms;

import java.util.Arrays;

public class Q01_AssignCookies{
    /**
     * https://leetcode.com/problems/assign-cookies/description/
     */

    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int childPtr=0, cookiePtr=0;
            int res=0;
            while(childPtr <g.length && cookiePtr < s.length){
                // take a cookie and try assigning it to a child
                if(s[cookiePtr]>=g[childPtr]){
                    res++; // add to answer
                    cookiePtr++; // move the pointers
                    childPtr++;
                }else{
                    cookiePtr++;
                }
            }
            return res;        
        }
    }
}