public class maxProduct {

    public int maxProduct(int[] nums) {

        if(nums.length == 0 || nums == null){
            return 0;
        }

        int prevMax = nums[0], prevMin = nums[0];
        int ans = nums[0], currMax = nums[0], currMin = nums[0];

        for(int i = 1; i < nums.length; i++){
            //
            currMax = Math.max(Math.max(prevMax*nums[i], prevMin*nums[i]), nums[i]);
            currMin = Math.min(Math.min(prevMax*nums[i], prevMin*nums[i]), nums[i]);

            ans = Math.max(ans, currMax);

            prevMax = currMax;
            prevMin = currMin;
        }
        return ans;
    }

    public static void main(String[] args) {
        maxProduct mp = new maxProduct();
        System.out.println(mp.maxProduct(new int[] {2, 3, 2, -2, 2}));
        String s = "he";
        String s1 = s.substring(0, 2);
        System.out.println(s1);
    }
}
