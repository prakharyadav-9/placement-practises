package dsa.sheet.a2z.basics;

public class Q1_countDigits {
    /*
     *Given a number N. Count the number of digits in N which evenly divide N.
     *Note :- Evenly divides means whether N is divisible by a digit i.e.
     *          leaves a remainder 0 when divided.
     *
     * URL: https://www.geeksforgeeks.org/problems/count-digits5716/1
     */
    int evenlyDivides(int N){
        //code here
        int digits=0;
        int n = N;
        while(n!=0){
            int rem = n%10;
            if(rem!=0 && N%rem == 0) digits++;
            n=n/10;
        }
        return digits;
    }

    public static void main(String ...args){
        int N=240;
        System.out.println(new Q1_countDigits().evenlyDivides(N));
    }

}
