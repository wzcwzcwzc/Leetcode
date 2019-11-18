import java.util.HashMap;
import java.util.Map;

public class lengthOfLongestSubstringKDistinct {


    /*
    * Given a string, find the length of the longest substring T that
    * contains at most k distinct characters.

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: T is "aa" which its length is 2.
    *
    * */

    public int lengthOfLongestSubstringKDistinct(String s, int k){

        //use sliding window and hashMap
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;


        for(i = 0; i < s.length(); i++){
            while (j < s.length() && map.size() <= k){
                //when map is not full, we keep putting character into map
                char c = s.charAt(j);
                if(map.containsKey(c)){
                    map.put(c, map.get(c) + 1);
                }else {
                    //if map size is reach to k, it means we cannot insert
                    //another different character
                    if (map.size() == k) {
                        break;
                    }
                    map.put(c, 1);
                }
                j++;
            }
            //update max value, characters in sliding window j-i can be used
            max = Math.max(max, j - i);
            char c = s.charAt(i);

            //update the map because i is going to move right
            if(map.containsKey(c)){
                int count = map.get(c);
                if(count > 1){
                    map.put(c, count - 1);
                }else{
                    map.remove(c);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "eceba";
        lengthOfLongestSubstringKDistinct l = new lengthOfLongestSubstringKDistinct();
        System.out.println(l.lengthOfLongestSubstringKDistinct(s, 2));

    }

}
