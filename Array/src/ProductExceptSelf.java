public class ProductExceptSelf {


    /*
    * Given an array nums of n integers where n > 1,
    * return an array output such that output[i] is equal to
    * the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity?
* (The output array does not count as extra space for the purpose of space complexity analysis.)
    *
    * */

    public int[] productExceptSelf(int[] nums) {

        //base case
        if (nums.length == 0) return null;

        //divide array into three parts
        //[] num []
        //example num=2 power=1*3*4=12
        //example num=1 power=2*3*4=24

        //use two arrays to store the [] []
        int[] leftTemp = new int[nums.length];
        int[] rightTemp = new int[nums.length];

        leftTemp[0] = 1;
        rightTemp[nums.length - 1] = 1;

        //[2, 3, 4]
        //[1,           1*2,  2*3*1=6]
        //[3*4*1=12,    4*1,        1]
        //-->[12, 8, 6]

        int[] ans = new int[nums.length];

        for(int i = 1; i < nums.length; i++){
            leftTemp[i] = leftTemp[i-1] * nums[i - 1];
        }

        for(int i = nums.length - 2; i >= 0; i--){
            rightTemp[i] = rightTemp[i + 1] * nums[i + 1];
        }

        for(int i = 0; i < nums.length; i++){
            ans[i] = leftTemp[i] * rightTemp[i];
        }


        return ans;
    }

    //follow up solution for no extra space
    public int[] productExceptSelfFollow(int[] nums) {

        //base case
        if (nums.length == 0) return null;

        //use ans to store the result
        int[] ans = new int[nums.length];

        ans[0] = 1;
        ans[nums.length - 1] = 1;

        for(int i = 1; i < nums.length; i++){
            ans[i] = ans[i-1] * nums[i - 1];
        }

        int right = 1;

        for(int i = nums.length - 1; i >= 0; i--){
            ans[i] = right * ans[i];
            right = right * nums[i];
        }

        return ans;
    }

}
