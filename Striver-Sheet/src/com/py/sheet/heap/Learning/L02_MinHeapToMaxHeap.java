package com.py.sheet.heap.Learning;

import com.py.sheet.heap.Heap;
import java.util.*;

public class L02_MinHeapToMaxHeap extends Heap {
    public L02_MinHeapToMaxHeap(int capacity) {
        super(capacity);
    }
    public static 
    void main(String args[]){
        int minHeap[] = 
                //{3, 4, 8, 11, 13}; //
                {1,2,3,4,};
    
        convertMinToMaxHeap(minHeap.length, minHeap);
        System.out.println(Arrays.toString(minHeap));
    }
    static void convertMinToMaxHeap(int N, int arr[]) {
    // code here
        for(int i = (N/2) -1 ;i>=0;i--){
            heapify(arr,N,i);
        }
    }
    private static
    void heapify(int []arr,int N,int i){
        while(true){
            int lCh = 2*i+1;
            int rCh = 2*(i+1);
            int largest = i;
            if(lCh<N&&arr[lCh]>arr[largest]) {
                largest = lCh;
            }   
            if(rCh<N&&arr[rCh]>arr[largest])    {
                largest = rCh;
            }
            if(largest!=i){
                swap(arr,i,largest);
                i = largest;
            }else{
                break;
            }
        }
    }
  private static
  void swap(int arr[],int idx1,int idx2){
      int t = arr[idx1];
      arr[idx1] = arr[idx2];
      arr[idx2] = t;
  }
    @Override
    public void insert(int ele) {
        if(this.size==this.capacity)    return;
        this.data[++this.size-1] = ele;
        for(int i= this.size-1;i!=0&& data[parent(i)]<data[i];){
            swap(i,parent(i));
            i = parent(i);

        }
    }
    @Override
    public void swap(int idx1, int idx2) {
        int t = data[idx1];
        data[idx1] = data[idx2];
        data[idx2] = t;
    }
}
