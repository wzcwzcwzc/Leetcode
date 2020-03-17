public class MaxSubArray {

    /*
    * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
    *
    * */

    //局部最优解-》全局最优

    public int maxSubArray(int[] nums){


        //greedy
        int currSum = nums[0];
        int maxSum = nums[0];

        for(int i = 1; i < nums.length; i++){
            //局部最优
            currSum = Math.max(nums[i], nums[i] + currSum);

            //全局最优
            maxSum = Math.max(maxSum, currSum);

        }

        return maxSum;

    }
}
