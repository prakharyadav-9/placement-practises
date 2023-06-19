package com.py.sheet.heap.Learning;

import com.py.sheet.heap.Heap;

public class L01_MinHeap extends Heap {

    public L01_MinHeap(int capacity) {
        super(capacity);
    }

    public static void main(String... args) {
        Heap min = new L01_MinHeap(4);
        System.out.println(min.size);
        min.insert(1);
        System.out.println(min.printdata());
        min.insert(2);
        System.out.println(min.printdata());
        min.insert(3);
        System.out.println(min.printdata());
        min.insert(-10);
        System.out.println(min.printdata());
        min.insert(-10);
        System.out.println(min.printdata());
        
        System.out.println(min.parent(2));
    }

    @Override
    public void insert(int ele) {
        if (this.size == this.capacity) {
            System.err.println("heap  capacity filled... :(");
            return;
        }
        ++this.size;
        this.data[this.size-1] = ele;
        for (int i = this.size-1; i != 0 && data[parent(i)] > data[i]; i = parent(i)) {
            swap(i, parent(i));
        }
    }

    @Override
    public void swap(int idx1, int idx2) {
        int t = data[idx1];
        data[idx1] = data[idx2];
        data[idx2] = t;
    }
}