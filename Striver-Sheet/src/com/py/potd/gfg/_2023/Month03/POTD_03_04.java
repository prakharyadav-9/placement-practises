package com.py.potd.gfg._2023.Month03;

import java.util.*;

public class POTD_03_04 {

	public static long bestNode(int N, int[] A, int[] P) {
		 
        // code here
		long maxSum=A[A.length-1];
		/*
		 * Approach 2:
		 * 	from each child ie. starting from end in arr go to parent calculating the parents
		 * and getting the maximum
		 */
		// seperating the leafs
//		System.out.println(Arrays.toString(A));
//		System.out.println(Arrays.toString(P));
		Set<Integer> parents = new TreeSet<>();
		for(int i=1;i<P.length;i++) {
			parents.add(P[i]);
		}
		
//		System.out.printf("parents-> %s\n",parents);
		List<Integer> leafs = new ArrayList<>();
		for(int i=1;i<=N;i++) {
			if(!parents.contains(i)) {
				leafs.add(i);
			}
		}
//		System.out.printf("leafs-> %s\n",leafs);

		/*
		 * REFERRED Solution
		 */
//		HashSet<Integer> set = new HashSet<>();
//        for(int k: P)
//            set.add(k);
//        System.out.println("parents:: "+set);
//        ArrayList<Integer> leafNode = new ArrayList<>();
//        for(int i = 1; i <= P.length; i++){
//            if(!set.contains(i))
//                leafNode.add(i);
//        }
//        System.out.println("leafs :: "+leafNode);
//        int answer = Integer.MIN_VALUE;
//        for(int leaf: leafNode){
//            int node = leaf;
//            int ans = 0;
//            while(node != -1){
//                ans*=-1;
//                ans += (A[node-1]);
//                answer = Math.max(answer, ans);
//                node = P[node-1];
//            }
//        }
//	System.out.println(answer);
		
		// starting from each leaf and going upto parent uptill root 
		// calculate f(B)
		for(int leaf:leafs) {
			int currNode  =leaf;
			int currMaxSum = 0;
			while(currNode!=-1) { // does not reaches the root
				currMaxSum*=-1;
				currMaxSum +=A[currNode-1];
				maxSum = Math.max(maxSum,currMaxSum);
				currNode = P[currNode-1];
			}
		}
		
		return maxSum;
     }
	public static void main(String[] args) {
		int arr[] = {12 ,-4 ,16,8,-2,0,17,17};//{3,1,2};//{1,2,3,};
		int  p [] = {-1 ,1 ,2 ,2 ,2 ,4, 4,1};//{-1,1,2};//{-1,1,1,};
		System.out.println(bestNode(arr.length,arr,p));
 	}

}
