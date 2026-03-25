package dsa.com.py.Blind75.T_00maths;

/**
 * Problem link:<a> https://takeuforward.org/plus/dsa/problems/reverse-a-number?source=strivers-a2z-dsa-track </a>
 */
public class Q_001ReverseNum {
    
    public int reverse(int n) {
        long rev =0;
        while(n!=0){
            int rightMostNumber = n%10;
            n/=10;
            rev = rev*10 + rightMostNumber;
        }
        if (rev>Integer.MAX_VALUE || rev <Integer.MIN_VALUE) return 0;
        return Math.toIntExact(rev);
    }

    public static void main(String...args){
    // the probelm is done in the above mentioned link itself
    int n = 1534236469;
    Q_001ReverseNum obj = new Q_001ReverseNum();
    System.err.println(obj.reverse(n));
    }
}
