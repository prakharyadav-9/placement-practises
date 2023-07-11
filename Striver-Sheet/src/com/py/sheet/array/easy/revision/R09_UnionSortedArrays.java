package com.py.sheet.array.easy.revision;

import java.util.*;

public class R09_UnionSortedArrays {
    public static void main(String[] args) {
		int [] arr1= {43,43}, arr2= {5,14,17,36,36,42};// {6,6,17, 17, 24, 30, 30 ,33, 37, 38, 38, 39, 40,44,46,47,48,50,50};
		System.out.println(sortedArray(arr1,arr2));
	}
    public static List< Integer > sortedArray(int []a, int []b) {
        // Write your code here
        List<Integer> ans = new ArrayList<>();
        int i=0,j=0,k=0;
        ans.add(k++,a[i]>b[j]?b[j++]:a[i++]);
        while(i<a.length&&j<b.length){  
            if(a[i]<b[j]){
                if(ans.get(k-1)!=a[i])
                    ans.add(k++,a[i]);
                i++;
            }else{
                if(ans.get(k-1)!=b[j])
                    ans.add(k++,b[j]);
                j++;
            }
        }
        while(i<a.length){
            if(ans.get(k-1)!=a[i])
                ans.add(k++,a[i]);
            i++;
        }
        while(j<b.length){
            if(ans.get(k-1)!=b[j])
                ans.add(k++,b[j]);
            j++;
        }
        // System.out.println(i+ " "+j+" "+k);
        return ans;
    }
}
