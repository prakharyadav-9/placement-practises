package com.py.sheet.linkedList.medium;

import java.util.ArrayList;

import com.py.sheet.linkedList.easy.NodeD;

public class Q26_FindPairsToTarget {

	public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, NodeD head) {
        // code here
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		
		// we will similar approach as binary search but instead of cutting the search space to half
		// I cut by one element
		NodeD left=head;
		NodeD right=head;
		
		if(head == null || head.next == null)
			return result;
		while(right.next!= null)
			right = right.next;
		while(left.data<right.data) {
			int sum = left.data+ right.data;
			if(sum==target) {
				ArrayList<Integer> pairs = new ArrayList<>();
				pairs.add(left.data);
				pairs.add(right.data);
				left = left.next;
				right=right.prev;
				result.add(pairs);
			}else if (sum<target){
				left=left.next;
			}else {
				right=right.prev;
			}
		}
		return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,5,6};//{1,2,4,5,6,8,9,};
		NodeD head = constructDLL(arr);
		int target=6;//7;
		ArrayList<ArrayList<Integer>> result = findPairsWithGivenSum(target, head);
		// result
		for(ArrayList<Integer> pair: result ) {
			for(Integer item: pair)
				System.out.printf(" %d",item);
			System.out.println();
		}
	}

	static
	NodeD constructDLL(int arr[]) {
        // Code here
		NodeD  head = null;
		NodeD  last = head;
		for(int i=0;i<arr.length;i++) {
			NodeD newNode = new NodeD(arr[i]);
			if(head==null) {
				last=head=newNode;
			}else {
				while(last.next!=null) {
					last = last.next;
				}
				newNode.prev = last;
				last.next = newNode;
			}
		}
//		t= last.next;
        return head;
    }
}
