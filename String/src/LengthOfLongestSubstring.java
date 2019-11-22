import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {


    /*
    * Given a string, find the length of the longest substring
    * without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
    *
    * */

    public int lengthOfLongestSubstring(String s){

        //using sliding windows

        //because we need to get substring without repeating characters
        //we can use hashSet to maintain the none repeating characteristic

        Set<Character> set = new HashSet<>();

        int left = 0;
        int right = 0;
        int ans = 0;

        while(right < s.length() && left < s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
                //after update the right index, we need to update ans
                ans = Math.max(ans, right - left);
            }else{
                //if already include, we can remove the left
                set.remove(s.charAt(left));
                left++;
            }
        }

        return ans;
    }
}
