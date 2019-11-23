public class LongestPalindrome {

    /*
    * Given a string s, find the longest palindromic substring in s.
    * You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
    *
    * */
    public String longestPalindrome(String s) {
        if (s.length() == 1)
            return s;
        if (s.length() == 0)
            return "";

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i ++){
            int len1 = subPalindromic(i, i, s);
            int len2 = subPalindromic(i, i+1, s);
            int len = Math.max(len1,len2);
            if (len > end - start){
                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start,end+1);
    }

    public int subPalindromic(int l, int r, String s){
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l --;
            r ++;
        }
        return r - l - 1;
    }

    //dp solution
    public String longestPalindromeWithDp(String s){

        //base case
        if(s.length() == 0) return "";



        //find dp equation

        /*
        * suppose dp[i][j] means it is palindrome between index i and j
        *
        * 1. i=j dp[i][j] = true;
        * 2. j-i < 2 means j = i + 1 if(s[i] == s[j]) true
        * 3. if j - i >= 2 means if(s[i] == s[j] && dp[i+1][j-1]) true
        * */

        int left = 0;
        int right = 0;
        //if s.length != 0, then the minimum value of len must be 1
        int len = 1;
        int n = s.length();
        int leftIndex = 0;
        boolean[][] dp = new boolean[n][n];

        for(right = 0; right < n; right++){
            //same character must be palindrome
            dp[right][right] = true;
            for(left = 0; left < right; left++){
                dp[left][right] = (right- left < 2 || dp[left+1][right-1]) && s.charAt(left) == s.charAt(right);
                //update length
                if(dp[left][right] && len < right - left + 1){
                    len = right - left + 1;
                    leftIndex = left;
                }

            }
        }
        return s.substring(leftIndex, leftIndex + len);
    }
}
