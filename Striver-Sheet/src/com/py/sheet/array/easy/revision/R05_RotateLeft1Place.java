package com.py.sheet.array.easy.revision;

public class R05_RotateLeft1Place {
    
    public static void main(String[] args) {
    int a[] = {1,2,3,4,5,6,7,};//2,3};//{1,1,2};//{1,1,2};//{1,3,4,5,6,12,17,19,28,28};//{2,20,20,40,60};//{3,5,10,10,10,15,15,20};
		int d= 2;
		// leftRotate(a,a.length,d);
        // R05_RotateLeft1Place obj = new R05_RotateLeft1Place();
        // obj.rotate(a,d);
        int ans[] = rotateArray(a,a.length);
		System.out.print("Elements-> [");
		for(int ele:ans) {
			System.out.print(ele + " ");
		}
		System.out.println("]");
	}
    static int[] rotateArray(int[] arr, int n) {
        // Write your code here.
        int ans[] = new int[n];
        System.arraycopy(arr,0,ans,0,n);
        rotate(ans,1);
        return ans;

    }
    private static void rotate(int[] nums, int k) {
        k=k%nums.length;
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        reverse(nums,0,nums.length-1);
    }
    private static void reverse(int[] arr,int s,int e){
        while(s<e){
            swap(arr,s,e);
            s++;
            e--;
        }
    }
    private static void swap(int arr[],int sIdx,int eIdx){
        int temp=arr[sIdx];
        arr[sIdx]=arr[eIdx];
        arr[eIdx]=temp;
    }

}
