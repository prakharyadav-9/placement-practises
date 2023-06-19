package com.py.sheet.heap.Learning;

import java.util.*;
import com.py.sheet.heap.Heap;

public class L03_ExtractMin extends Heap{

    L03_ExtractMin(int capacity){
        super(capacity);
    }
    L03_ExtractMin(int arr[]){
        super(arr);
    }
    public static
    void main(String...args){
        int arr[] = {4,3,2,1};
        Heap heap = new L03_ExtractMin(arr);
        heap.buildHeap();
        // System.out.printf("Min heap constructed:: %s\n",Arrays.toString(heap.data));
        System.out.printf("Constructed Min Heap:: %s\n",Arrays.toString(arr));
        int extracted = ((L03_ExtractMin) heap).extractMin();
        System.out.printf("extrected:: %d\n",extracted);
        heap.printHeapArray();
        System.out.printf("After Extraction:: %s\n",Arrays.toString(arr));
        extracted = ((L03_ExtractMin) heap).extractMin();
        System.out.printf("extrected:: %d\n",extracted);
        heap.printHeapArray();
        System.out.printf("After Extraction:: %s\n",Arrays.toString(arr));
        // heap.printHeapArray();

    }

    int extractMin(){
        if(size==0)
            return Integer.MAX_VALUE;
        if(size==1){
            size--;
            return data[0];
        }
        swap(0,size-1);
        size--;
        heapify(0);
        int val = data[size];
        data[size] = Integer.MAX_VALUE;
        return val;
    }

    
    @Override
    public void insert(int ele) {
        if(size==capacity) return ;
        data[++this.size-1] =ele;
        for(int i=this.size-1;i>=0;){
            
        }
    }

    @Override
    public void swap(int idx1, int idx2) {
        int t=data[idx1];
        data[idx1] = data[idx2];
        data[idx2] = t;
    }
    @Override
    public void heapify(int i){
        // System.out.println("heapify called of child");
        int lch = leftCh(i),rch =rightCh(i);
        int smallest = i;
        if(lch<size&&data[lch]<data[i]) smallest = lch;
        if(rch<size&&data[rch]<data[smallest]) smallest = rch;
        if(smallest!=i){
            swap(smallest, i);
            heapify(smallest);
        }
    }
}