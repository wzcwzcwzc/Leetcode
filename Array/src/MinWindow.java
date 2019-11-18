
/*
*
* Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
* */
public class MinWindow {
    public String minWindow(String s, String t) {

        //sliding window

        //set int[] to store t and state of s, then iterate s
        int[] memo = new int[128];
        int left = 0;
        //final left pointer
        int minLeft = -1;
        //final length of the string
        int minLength = Integer.MAX_VALUE;
        //find whether the s.substring has all character in t
        int count = 0;

        //put t into memo
        for(int i = 0; i < t.length(); i++){
            memo[t.charAt(i)]++;
        }

        for(int i = 0; i < s.length(); i++){

            if(--memo[s.charAt(i)] >= 0){
                //find the character that t has
                count++;
            }
            //if not find just move on to next character until the end of s

            while(count == t.length()){
                //store the state of current because we find one of solutions
                if(minLength > i - left + 1){
                    minLength = i - left + 1;
                    minLeft = left;
                }

                //after store the current state, we need to move on and find whether there is better solution
                //if the character at left index is one of characters in t, if we delete it, we need to update memo
                //no matter what characters in (minLeft->minLeft+minLength), we do not need to care about the value in memo
                if(++memo[s.charAt(left)] > 0){
                    count--;
                }
                left++;
            }
        }

        return minLeft == -1 ? "" : s.substring(minLeft, minLeft + minLength);
    }
}
