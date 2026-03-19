package dsa.com.py.Blind75.T_03DP;

public class Q_03_DecodeWays {

    public static void main(String []args){
        Q_03_DecodeWays x = new Q_03_DecodeWays();
        Solution s = x.new Solution();
        String inp = "226";
        int ans = s.numDecodings(inp);
        System.out.println(ans);
    }
    

    class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int dp[] = new int[n+1]; // dp including `i` characters
        dp[0] = 1; // empty string
        dp[1] = isValidCharacter(s.charAt(0))? 1 : 0; // this has to be only one character
        for(int i=2; i<=n; i++){
            dp[i] = isValidCharacter(s.charAt(i-1))? dp[i-1]:0; 
            dp[i] += (isValidCharacter(s.charAt(i-2), s.charAt(i-1))?dp[i-2]: 0 );
        }
        return dp[n];
    }
    private boolean isValidCharacter(char ch){
        return ch != '0';
    }

    private boolean isValidCharacter(char ch1, char ch2){
        int numeric = Integer.parseInt(""+ch1+ch2);
        if(numeric<10 || numeric >26) return false;
        return true;
    }

}
}
