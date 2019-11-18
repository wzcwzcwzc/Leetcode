/*
* Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*
*
* */



public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        //use sliding window
        //use array to store the state

        int max = 0;
        int left = 0;
        int right = 0;

        //ASCII has 128 different characters, use the array as hashMap
        boolean[] visited = new boolean[128];

        while(right < s.length()){
            if(!visited[s.charAt(right)]){
                visited[s.charAt(right)] = true;
                right++;
            }else{
                max = Math.max(max, right - left);
                //need to get new position of right index
                while(left < right && s.charAt(left) != s.charAt(right)){
                    visited[s.charAt(left)] = false;
                    left++;
                }
                left++;
                right++;
            }
        }
        max = Math.max(max, right - left);
        return max;
    }
}
