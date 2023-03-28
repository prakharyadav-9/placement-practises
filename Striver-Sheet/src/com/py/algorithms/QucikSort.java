import java.util.Arrays;

public class QucikSort {
    public static void main(String args[]){
        int arr[]= {4,6,2,5,7,9,4,1,3,};
        System.out.println(Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low<high){
            int partitionIdx = partition(arr,low, high);
            quickSort(arr, low, partitionIdx-1);
            quickSort(arr, partitionIdx+1, high);
        }
    }

    static int partition(int arr[], int low,int high){
        int pivotIdx = low;
        int i=low;
        int j=high;
        while(i<j){
            while(arr[i]<=arr[pivotIdx] && i<high)
                i++;
            while(arr[j]> arr[pivotIdx] && j>=low+1)
                j--;

            if(i<j)
                swap(arr, i, j);    
        }
        swap(arr, pivotIdx, j);
        return j;

    }

    private static void swap(int arr[], int i,int j){
        int t=arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
