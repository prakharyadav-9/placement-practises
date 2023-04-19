package com.py.sheet.bitManupilation.learning;

public class L06_Find2unpairAmongPairs {
    
    /*
     * From an array where expect two numbers are in pairs
     * find those tow numbers
     */
    static
    void findOddNumbers(int arr[]){
        // first calculate overall xor
        int XOR=0;
        for(int ele:arr){
            XOR^=ele;
        }
        System.out.printf("Xored Number = %d \n",XOR);
        int idx=0;
        // find the index where the number differs
        // we will calculate the LeftMost bit where it differs
        while(XOR!=0){
            if((XOR&1)==1){
                break;
            }
            idx++;
            XOR=XOR>>1;
        }
        int XOR1=0,XOR2=0;
        System.out.printf("Found idx:: %d \n",idx);
        // in the array logically think as two sets the elements differ by the bits at idx
        for(int ele:arr){
            if((ele&(1<<idx))==0)
                XOR1 ^=ele;
            else
                XOR2^=ele;
        }
        System.out.printf("Numbers are %d and %d", XOR1,XOR2);
    }   

    public static void main(String...args){
        int arr[]= {1,2,4,4,2,5,7,8,5,8,7,10};
        findOddNumbers(arr);
    } 
}
