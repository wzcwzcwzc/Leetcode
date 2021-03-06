public class MaxArea {

    /*
    * leetcode 11 contain with most water
    * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
    * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
    * which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.



The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case,
* the max area of water (blue section) the container can contain is 49.
    *
    * */

    public int maxArea(int[] height){

        //two pointers, one from begin, one from last
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;

        //the height of water determined by the highest bar, if we find small bar, we need to move pointer
        //so that we may find better bar than previous one
        while(left < right){
            maxWater = Math.max(maxWater, Math.min(height[left], height[right]) * (right - left));
            if(height[left] <= height[right]){
                left++;
            }else{
                right--;
            }
        }

        return maxWater;

    }
}
