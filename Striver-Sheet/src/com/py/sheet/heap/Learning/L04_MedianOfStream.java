package com.py.sheet.heap.Learning;
import java.util.*;
public class L04_MedianOfStream {
    public static void 
    main(String...args){
        int stream[] = {25,7,10,15,20};//{5,3,8};// {5,3,8};//
        ArrayList<Float> result = getStreamMedian(stream);
        System.out.println(result);
    }
    private static
    ArrayList<Float> getStreamMedian(int []stream){
        ArrayList<Float> result=new ArrayList<>();
        PriorityQueue<Integer> greaterHalf= new PriorityQueue<>(),
                    smallerHalf = new PriorityQueue<>((a,b)->b-a); // max Heap
        // currently both the heaps have equal elements = 0
        // idea is try to maintain equal elements and oddth element in C1
        smallerHalf.offer(stream[0]);
        // put the first element into smallerHalf (1st COntainer)
        result.add(1f*stream[0]); // make the only element as median
        // System.out.println(result);
        for(int i=1;i<stream.length;i++){
            int c1Size = smallerHalf.size();
            int c2Size= greaterHalf.size();
            if(c1Size==c2Size){ 
                // now oddth elemnt would come
                if(stream[i]<=smallerHalf.peek()){
                    // inncomming element belongs to smaller half
                    smallerHalf.offer(stream[i]);
                }else{
                    // element belongs to larger half
                    greaterHalf.offer(stream[i]);
                    // now rearrange so that extra element remains in C1
                    smallerHalf.offer(greaterHalf.poll());
                }
                // now print the largest element from C1 as median
                float median = 1f*smallerHalf.peek();
                // System.out.println(median);
                result.add(median);
            }
            else{ 
                // previously the heaps were unequal insize
                if(smallerHalf.peek()>stream[i]){ // only sHalf might have element 
                    // element belongs to smaller half 
                    // transfer one maximum element from smaller half to greater half
                    greaterHalf.offer(smallerHalf.poll());
                    // now you can put element safely in smaller half 
                    // & will maintain equal size after that
                    // smallerHalf.offer(greaterHalf.poll());
                    smallerHalf.offer(stream[i]);
                }else{
                    // element belongs to greater half
                    greaterHalf.offer(stream[i]);
                }
                // now sizes becomes equal and middle most elements relies on heap root
                float median = 1f*(smallerHalf.peek()+greaterHalf.peek())/2;
                // System.out.println(median);
                // print the median
                result.add(median);
            }
        }
        return result;
    }
}
