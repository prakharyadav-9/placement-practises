package dsa.sheet.a2z.basics;

public class Q2_ReverseNum {

    public int reverse(int x) {
        boolean isNeg = x<0;
        String givNum = getRev(x);
        if(overFlow(givNum)) return 0;
        int rev = Integer.parseInt(givNum);
        return isNeg?-rev:rev;
    }
    String getRev(int x){
        StringBuilder num = new StringBuilder(String.valueOf(x));
        num.reverse();
        if(x<0) num.delete(num.length()-1,num.length());
        return num.toString();
    }
    boolean overFlow(String num){
        boolean t= String.valueOf(Integer.MAX_VALUE).compareTo(num) > 1;
        return false;
    }
    public static void main(String[] args){
        int N=-2147483648;
        System.out.println(new Q2_ReverseNum().reverse(N));
    }
}
