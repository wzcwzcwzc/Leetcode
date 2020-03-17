import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
/*
* Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*
* */

    Map<String, String> map = new HashMap<>();

    List<String> ans = new ArrayList<>();


    public List<String> letterCombinations(String digits) {

        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");

        //backtracking
        if(digits.length() != 0){
            backtrack("", digits);
            return ans;
        }else{
            return ans;
        }

    }


    //string combination, string next_digit
    public void backtrack(String combination, String next_digit){

        //goal, if there is no next_digits left, which means the combination is full, we can add it to ans
        if(next_digit.length() == 0){
            ans.add(combination);
        }else{
            //choice
            //if there still next_digit, we can use substring to cut it and get characters
            String digit = next_digit.substring(0, 1);
            String letters = map.get(digit);
            //iterate all letters and combine it with combination
            for(int i = 0; i < letters.length(); i++){
                String letter = letters.substring(i, i+1);
                //backtrack and update the next_digit
                backtrack(combination+letter, next_digit.substring(1));
            }
        }
    }

    public static void main(String[] args) {
        int x = (int)Math.sqrt(12);
        String s = "0" + "0" + 3;
        System.out.println(s);
    }

}
