package com.py.sheet.array.medium;

import java.util.HashMap;
import java.util.Map;

public class Q18_MajorityElements {
	

	static int majorityElementMaps(int a[]) {
      // your code here
		// <element, ocurrance>
		Map<Integer, Integer> map= new HashMap<>();
		for(int ele:a) {
			if(map.containsKey(ele)) {
				map.put(ele, map.get(ele)+1);
			}else {
				map.put(ele,0);
			}
		}
		int occ=-1;
		int element=-1;
		for(int ele:a) {
//			occ=Math.max(occ,map.get(ele));
			int curr = map.get(ele);
			if(occ<curr) {
				occ=curr;
				element=ele;
			}
		}
		return (element>a.length/2)?element:-1;
	}
	
	
	static int majorityElement(int a[], int size)
    {
		// we are using Moore's algorithm
		/*
		 * for the given condition it Moore's algorithm would work
		 * there will be atleast one place where the Majority element will occur contigiously
		 * otherwise the condition is not satisfied
		 * 
		 *      [x,_,x,_,x,_]
		 *      
		 * preMaj stores the element that is Majority
		 * after that we need to check the Majority if its really majority or not
		 * and return the result.
		 * 
		 */
		int prevMaj=-1;
		int count=0;
		for(int i=0;i<size;i++) {
			if(count==0) {
				prevMaj=a[i];
				count++;
			}else if(prevMaj == a[i]) {
				count++;
			}else if( a[i]!=prevMaj) {
				count --;
			}
		}
		int actualCount=0;
		int condition=size/2;
		for(int i: a) {
			if(i==prevMaj) {
				actualCount++;
			}
		}
		if(actualCount>condition)
			return  prevMaj;
		
		return -1;
    }
	
	public static void main(String[] args) {
		int A[] = {1,1,11,1,1,1,11,1,1,1,1,11,1,};//{1,2,3};//{3,1,3,3,2};
		System.out.println(majorityElement(A, A.length));

	}

}
