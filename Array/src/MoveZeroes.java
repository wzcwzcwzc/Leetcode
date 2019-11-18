public class MoveZeroes {

    public void moveZeroes(int[] nums){

        /*
        *
        *
        * Given an array nums, write a function to move all 0's to the end of it
        * while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
        *
        * */


        //O(1) space complexity and O(n) time complexity

        //use two pointers, one for index of findZero, one for iterate the whole array


        int findZero = 0;
        int i = 0;
        for(i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[findZero] = nums[i];
                findZero++;
            }
        }

        //need to update index after findZero index
        for(int j = findZero; j < nums.length; j++){
            nums[j] = 0;
        }
    }
}
