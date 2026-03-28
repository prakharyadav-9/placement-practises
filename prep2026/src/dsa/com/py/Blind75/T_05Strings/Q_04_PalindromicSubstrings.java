package dsa.com.py.Blind75.T_05Strings;

import java.util.HashSet;
import java.util.Set;

public class Q_04_PalindromicSubstrings {
    
    class Solution {
        public int countSubstrings(String s) {
            int n;
            int ans[] = new int[1];
            if(s == null || (n=s.length()) == 0) return 0;
            for(int i =0; i<n; i++){
                // expand both sides 
                expandAroundCentre(s, i, i, ans);
                expandAroundCentre(s,i, i+1, ans);
            }
            return ans[0];
        }

        private void expandAroundCentre(String s, int left, int right, int []ans){
            while(left>= 0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                ans[0]++;
                left--;
                right++;
            }
        }
    }
/*
Yes, in the expand-around-center approach (your current implementation), there is some repeated work, but it is minimized compared to brute-force methods.

Details:
Expand-Around-Center Approach
For each character (and each pair of adjacent characters), you expand outward as long as the substring is a palindrome.
Each palindrome is counted exactly once, and each possible center is only expanded once.
There is some overlap in the substrings checked, but each expansion is unique to its center, so the repeated work is limited.
Brute-Force Approach (for comparison)
Checks every possible substring and tests if it is a palindrome, leading to a lot of repeated character comparisons.
Dynamic Programming (DP) Approach
Avoids repeated work by storing results in a table (dp[i][j]) so that the result for each substring is computed only once and reused for longer substrings.
Summary
The expand-around-center method is efficient and avoids most repeated work, but there is still some overlap in the substrings checked.
The DP approach further reduces repeated work by caching results for all substrings.
If you want to avoid all repeated work, the DP approach is preferred, especially for collecting or reusing palindromic information. For just counting, expand-around-center is already quite efficient.
*/
    /*
    ## DP Solution 
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 1 || len == 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j]) {
                    count++;
                    // To collect substrings: list.add(s.substring(i, j + 1));
                }
            }
        }
        return count;
    }
    */
}
