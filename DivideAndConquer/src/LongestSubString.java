import java.util.*;

public class LongestSubString {

    public int longestSubstring_1(String s, int k) {

        if(s.length() == 0) return 0;

        int i = 0;
        int n = s.length();
        int res = 0;

        while(i + k <= n){
            int max_index = i;
            int[] m = new int[26];
            int mask = 0;
            for(int j = i; j < n; j++){
                int index = s.charAt(j) - 'a';
                ++m[index];
                if(m[index] < k){
                    mask = mask | 1 << index;
                }else{
                    mask = mask & ~(1 << index);
                }
                if(mask == 0){
                    res = Math.max(res, j - i + 1);
                    //assign j to max_index means the part i to j can be used in result,
                    // and there is no need for i trasverse i to j again,
                    // so just reset max_index so that we avoid i+1 to j part
                    max_index = j;
                }
            }
            i = max_index + 1;
        }
        return res;
    }


    public int longestSubstring_2(String s, int k) {
        //divide and conquer

        /*
         * search the whole array and find out which character is smaller than k
         * if so, set the character as a '/' and use recursion to find both sides of '/'
         *
         * */

        //traverse whole array, put each character into char arr
        char[] c = s.toCharArray();
        return helper(c, 0, s.length(), k);

    }

    public int helper(char[] s, int start, int end, int k){

        // base case
        if(start > end) return 0;

        //calculate number of characters and store them into char[]
        int[] m = new int[26];

        for(int i = start; i < end; i++){
            int index = s[i] - 'a';
            m[index]++;
        }

        for(int i = 0; i < 26; i++){
            if(m[i] < k && m[i] > 0){
                for(int j = start; j < end; j++){
                    if(s[j] == i + 'a'){
                        //if the current character belongs to characters which is less than k, then
                        //do divide operation, and try to find best solution for both sides
                        int left = helper(s, start, j, k);
                        int right = helper(s, j + 1, end, k);
                        return Math.max(left, right);
                    }
                }
            }
        }
        //after finish search, if still not return which means current right-left is best ans

        return end - start;
    }


    public static void main(String[] args) {
        LongestSubString ls = new LongestSubString();
//        System.out.println(ls.longestSubstring_2("aaabab", 3));
//        List<List<Integer>> l = ls.subsets(new int[] {1,2});
//        for(int i = 0; i < l.size(); i++){
//            System.out.println(l.get(i));
//        }

    }
}
