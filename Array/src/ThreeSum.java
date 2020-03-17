import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ThreeSum {

    /*
    *
    * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
    *
    * */



    public int threeSumClosest(int[] nums, int target){
        //sort

        //use two pointers left and right


        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];

        int diff = Math.abs(closest - target);

        for(int i = 0; i < nums.length - 2; i++){
            //set two pointers
            int left = i + 1;
            int right = nums.length - 1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                int newDiff = Math.abs(sum - target);

                //update the closest if newDiff is smaller than diff
                if(newDiff < diff){
                    diff = newDiff;
                    closest = sum;
                }

                if(sum < target){
                    left++;
                }else{
                    right--;
                }
            }

        }


        return closest;


    }





}
