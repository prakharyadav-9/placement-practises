package dsa.sheet.a2z.basics;

public class Q3_CheckPalindrome {

    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int rev = 0, n =x;
        while(n!=0){
            int rem = n%10;
            rev = 10*rev + rem;
            n = n/10;
        }
        return rev ==x;
    }

    public static void main(String args[]){
        int N=121;
        System.out.println(new Q3_CheckPalindrome().isPalindrome(N));
    }

}
