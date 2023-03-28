import java.util.*;

public class MergeSort{
	
	static
	void mergeSort(int arr[], int low,int high) {
		if(low>=high)
			return ;
		int mid = low + (high-low)/2;
		mergeSort(arr,low,mid);
		mergeSort(arr,mid+1,high);
		merge(arr,low,mid,high);
		
	}
	static
	void merge(int arr[], int low,int mid,int high) {
		// make an empty dataStructre to hold the elements
		List<Integer> temp = new ArrayList<>(high-low+1);
		int left=low;
		int right = mid+1;
		// putting elements into temp array
		while(left<=mid&& right<=high) {
			if(arr[left]<=arr[right]) {
				temp.add(arr[left++]);
			}else {
				temp.add(arr[right++]);
			}
		}
		// handling still elements left
		while(left<=mid) {
			temp.add(arr[left++]);
		}
		while(right<=high) {
			temp.add(arr[right++]);
		}
		// putting the elements into actual elements
		for(int i=low,idx=0;i<=high;i++,idx++) {
			arr[i] = temp.get(idx);
		}
		
	}
	
	public static void main(String arg[]) {
		int arr[] = {13,2,1,4,1,5,6,4,2,};
		System.out.println(Arrays.toString(arr)+ " Length ="+ arr.length);
		mergeSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr)+ " Length ="+ arr.length);
	}
	
	
}