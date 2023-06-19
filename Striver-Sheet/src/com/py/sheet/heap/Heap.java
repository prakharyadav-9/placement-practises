package com.py.sheet.heap;

import java.util.*;

public abstract class Heap {
    public int data[], capacity, size;
    public Heap(int capacity){
        data = new int[this.capacity = capacity];
        Arrays.fill(data,Integer.MAX_VALUE);
        size=0; // initial size
    }
    public Heap(int arr[]){
        this.data = arr;
        this.capacity = this.data.length;
        this.size=this.capacity;
    }
    public int parent(int i){
        return (i-1)/2;
    }
    public int leftCh(int i){
        return 2*i+1;
    }
    public int rightCh(int i){
        return 2*(i+1);
    }
    public void heapify(int i){
        System.out.println("heapify called of parent !");
    }
    public void buildHeap(){
        int startIdx = size/2 -1;
        for(int i = startIdx;i>=0;i--){
            heapify(i);
        }
    }
    public void printHeapArray(){
        System.out.print("\n[");
        for(int i=0;i<size;i++){
            System.out.printf("%d ",data[i]);
        }
        System.out.println("]");
    }
    public abstract void insert(int ele);
    public abstract void swap(int idx1,int idx2);
    public String printdata() {
        return Arrays.toString(this.data);
    }
}
