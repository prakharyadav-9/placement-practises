package com.py.sheet.tree.binarytree.questions;

public class Q01_CntNodesAtIthLevel {
    public static 
    void main(String...args){
        int level = 4;
        System.out.println(countNodes(level));
    }
    private static 
    int power(int a,int power){
        int result = 1;
        while(power>0){
            int lastBit = 1&power;
            if(lastBit>0)
                result*=a;

            a*=a;
            power=power>>1;    
        }
        return result;
    }
    static int countNodes(int i) {
        // code here
        // return 1<<(i-1);
        return power(2, i-1);
    }
}
