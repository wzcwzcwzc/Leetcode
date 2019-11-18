public class LCS {

    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length() == 0 || text2.length() == 0)
            return 0;

        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();


        int[][] dp = new int[t1.length + 1][t2.length + 1];

        for(int i = 1; i < dp.length; i++){

            for(int j = 1; j < dp[0].length; j++){

                if(t1[i-1] == t2[j-1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        //print the common sequence
        int i = dp.length - 1;
        int j = dp[0].length - 1;
        int index = dp[t1.length][t2.length];
        char[] lcs = new char[index];

        while(i > 0 && j > 0){
            if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                lcs[index - 1] = text1.charAt(i - 1);
                index--;
                i--;
                j--;
            }else if(dp[i - 1][j] > dp[i][j - 1]){
                i--;
            }else{
                j--;
            }
        }

        for(int k = 0; k < lcs.length; k++){
            System.out.print(lcs[k]);
        }

        return dp[t1.length][t2.length];

    }

    public static void main(String[] args) {
        LCS lcs = new LCS();
        lcs.longestCommonSubsequence("abcde", "bdhe");

        for(int i = 3; i < 10; i++){
            if(i % 2 == 0) {
                System.out.println(i);
                break;
            }
        }
    }

}
