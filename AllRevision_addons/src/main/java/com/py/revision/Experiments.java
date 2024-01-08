package com.py.revision;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Experiments {
    private int x = 10;
    int acc = 10;
    
    /*
        ERROR: cannot reduce visibilty of overriden function
    @Override
    private String toString(){
        return "some Implementation";
    }
    */
    Experiments(){}
    Experiments(long a){}

    static class Sub{
        int subV =10;
        static final int val=10;
        void add(){
            // subV=x;
            System.out.println(val);
            // we can access static value from non static block
            // here in case inner class we declared static member as final
        }
        public static void main(String ...args){

        }
    }
    private void foo(){}



    // int apError = 10 + 10d;
    protected int xxx=25;
    public static void main(String...args) throws Exception{
        char sex =10;
        Experiments objExp = new Experiments(sex);
        int a =10;
        // a=xxx; cannot make a static reference to non static field
        int ans = a++ + a++;
        System.out.println(ans);
        System.out.println(a);
        // InputStreamReader isr = new InputStreamReader(System.in);
        // BufferedReader br = new BufferedReader(isr);
        // br.readLine();
        // br.close();
        // isr.close();
        // String pussy = br.readLine();
        // StringTokenizer st = new StringTokenizer(pussy, " ",true);
        // System.out.println(st.nextToken());
        // OutputStreamWriter  osr = new OutputStreamWriter(System.out);
        // BufferedWriter  bw = new BufferedWriter(osr);
        // // osr.append(pussy);
        // bw.flush();
        // bw.close();
        // double d  = Double.parseDouble(br.readLine());
        // System.out.println(d);

        // int arr[] = {};
        // System.out.println(Arrays.toString(arr));
        // // arr[0]=2;
        // arr = new int[6];
        // System.out.println(arr.getClass());
        // System.out.println(Arrays.toString(arr));
        String s4= "pussy";
        s4.intern();
        byte []bar = {100,101,102,103,104};
        String s1 = new String(bar);
        System.out.println(s1);
        System.out.println((int)'a');
        s1.equals(s1);

    }
}

/*   
  
 public class Superclass {
     // public Superclass(){}
     int se=10;
     public Superclass(int value) {
        // Constructor logic
    }
    void foo() {}
}

public class Subclass extends Superclass {
    // int se =17; // if not defined it will take it from the parent else locally
    int s = se;
    // @Override
    public void foo(){

    }
    public Subclass(int value) {
        // Compiler will produce an error if you don't provide "super(value);" here
        // Subclass constructor logic
    }
}


*/

 interface Pussy extends Comparable<Pussy>,Comparator<Pussy>{
    // Comparator
    int sex=911;
    static int bob=8080;

}