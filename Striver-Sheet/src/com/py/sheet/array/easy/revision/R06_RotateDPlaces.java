package com.py.sheet.array.easy.revision;

public class R06_RotateDPlaces {
    public static void main(String[] args) {
		int a[] = {-1,-100,3,99};//{1,2,3,4,5,6,7,};//2,3};//{1,1,2};//{1,1,2};//{1,3,4,5,6,12,17,19,28,28};//{2,20,20,40,60};//{3,5,10,10,10,15,15,20};
		int d= 2;
		// leftRotate(a,a.length,d);
        R06_RotateDPlaces obj = new R06_RotateDPlaces();
        obj.rotate(a,d);
		System.out.print("Elements-> [");
		for(int ele:a) {
			System.out.print(ele + " ");
		}
		System.out.println("]");
	}
    /*
     * Right Rotate
     */
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,nums.length-k-1,nums.length-1);
    }
    private void reverse(int[] arr,int s,int e){
        while(s<e){
            swap(arr,s,e);
            s++;
            e--;
        }
    }
    private void swap(int arr[],int sIdx,int eIdx){
        int temp=arr[sIdx];
        arr[sIdx]=arr[eIdx];
        arr[eIdx]=temp;
    }
}
