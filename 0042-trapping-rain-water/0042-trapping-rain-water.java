class Solution {
    public int trap(int[] height) {

        // Pointer at the beginning
        int left = 0;

        // Pointer at the end
        int right = height.length - 1;

        // Maximum height seen so far from left side
        int leftMax = 0;

        // Maximum height seen so far from right side
        int rightMax = 0;

        // Stores total trapped water
        int water = 0;

        // Process until both pointers meet
        while (left < right) {

            // We always process the smaller height
            // because trapped water depends on the
            // minimum of leftMax and rightMax.
            if (height[left] < height[right]) {

                // If current height is greater than
                // leftMax, update leftMax
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                }
                else {
                    // Water trapped at this index
                    // = leftMax - current height
                    water += leftMax - height[left];
                }

                // Move left pointer
                left++;
            }
            else {

                // If current height is greater than
                // rightMax, update rightMax
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                }
                else {
                    // Water trapped at this index
                    // = rightMax - current height
                    water += rightMax - height[right];
                }

                // Move right pointer
                right--;
            }
        }

        return water;
    }
}