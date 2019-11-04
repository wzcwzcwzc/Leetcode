public class countSubstrings {

    static int res = 0;

    int countSubstrings(String s) {

        if (s.length() == 0) {
            return 0;
        }

        for (int i = 0; i < s.length(); i++) {
            helper(i, i, s, res);
            helper(i, i + 1, s, res);
        }

        return res;
    }
    //store the result we have covered,
    //从一个点向周围发散，使用递归

    void helper(int i, int j, String s, int res){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            --i;
            ++j;
            ++this.res;
        }
    }

    public static void main(String[] args) {
        String s = "aaa";
        countSubstrings c = new countSubstrings();
        System.out.println(c.countSubstrings(s));
    }
}
