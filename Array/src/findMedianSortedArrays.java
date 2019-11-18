public class findMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //use binary search to find median

        //avg(max(x,y), min(x,y))

        //x is nums1.length, y is nums2.length

        //suppose the posX is the middle position of nums1, while posY = (x+y+1)/2 - posX

        //

        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;
        int low = 0;
        int high = x;

        while(low <= high){

            //the length of left part of x and y need to be the same as right part of x and y
            //x1 x2 x3
            //y1 y2 y3

            //group left: (x1 x2) and y1 groupLength = 3
            //group right: x3 and (y1 ,y2) groupLength = 3
            int posX = (low + high) / 2;
            int posY = (x + y + 1) / 2 - posX;

            int maxLeftX = (posX == 0 ? Integer.MIN_VALUE : nums1[posX - 1]);
            int minRightX = (posX == x ? Integer.MAX_VALUE : nums1[posX]);

            int maxLeftY = (posY == 0 ? Integer.MIN_VALUE : nums2[posY - 1]);
            int minRightY = (posY == y ? Integer.MAX_VALUE : nums2[posY]);

            //found: if maxLeftX <= minRightY and minRightX >= maxLeftY
            if(maxLeftX <= minRightY && minRightX >= maxLeftY){
                //if the length of num1+num2 is even -> (max(maxLeftX, maxLeftY) + min(minRightX, minRightY)) / 2
                if((x + y) % 2 == 0){
                    //even
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                }else{
                    //the total length is odd -> max(maxLeftX, maxLeftY)
                    return (double) Math.max(maxLeftX, maxLeftY);
                }

                //we do not find the median value, we need to modify the posX
            }else if(maxLeftX > minRightY){
                //if maxLeftX is bigger than minRightY, it means the X is big and posX is too right
                //we need to move to left and let it become smaller
                high = posX - 1;
            }else{
                low = posX + 1;

            }

        }
        return 0.0;
    }
}
