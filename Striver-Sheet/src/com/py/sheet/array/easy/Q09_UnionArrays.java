package com.py.sheet.array.easy;

import java.util.ArrayList;

public class Q09_UnionArrays {

	//Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m){
        ArrayList<Integer> union = new ArrayList<>(Math.min(n,n));
        int i=0;
        int j=0;
        while(i<n && j<m) {
        	if(i>0  && arr1[i]==arr1[i-1]) {
        		i++;
        		continue;
        	}
        	if(j>0  && arr2[j]==arr2[j-1]) {
        		j++;
        		continue;
        	}
        	if(arr1[i]<arr2[j])
        		union.add(arr1[i++]);
        	else if(arr2[j]<arr1[i])
        		union.add(arr2[j++]);
        	else { //if(arr1[i]==arr2[j]) {
        		union.add(arr1[i]);
        		i++;
        		j++;
        	}
        }
        while(i<n) {
            if(i==0)
                union.add(arr1[i]);
        	else if( arr1[i]!=arr1[i-1]) {	
        		union.add(arr1[i]);
        	}
        	i++;
        }
        while(j<m) {
            if(j==0)
                union.add(arr2[j]);
        	else if(j>0 &&arr2[j]!=arr2[j-1]) {
        		union.add(arr2[j]);
        	}
        	j++;
        }
        return union;
    }
    
	public static void main(String[] args) {
		int [] arr1= {43}, arr2= {5,14,17,36,42};// {6,6,17, 17, 24, 30, 30 ,33, 37, 38, 38, 39, 40,44,46,47,48,50,50};
		System.out.println(findUnion(arr1,arr2,arr1.length, arr2.length));
	}

}
