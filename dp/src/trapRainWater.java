public class trapRainWater {
    public int trap(int[] height) {

        int ans = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int max_right = 0;
        int max_left = 0;

        //determine the left bound of each slot
        for (int i = 0; i < height.length; i++){
            maxLeft[i] = Math.max(max_left, height[i]);
            max_left = maxLeft[i];
        }

        //determine the right bound of each slot
        for(int j = height.length - 1; j >= 0; j--){
            maxRight[j] = Math.max(max_right, height[j]);
            max_right = maxRight[j];
        }

        //ans = currentMinHeight - height[i]
        for(int k = 0; k < height.length; k++){
            ans = ans + (Math.min(maxLeft[k], maxRight[k]) - height[k]);
        }

        return ans;
    }
}
