class Solution {
    public void nextPermutation(int[] nums) {

        int n = nums.length;

        // Step 1: Find break point
        int ind = -1;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                ind = i;
                break;
            }
        }

        // If array is completely decreasing
        if (ind == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 2: Find next greater element
        for (int i = n - 1; i > ind; i--) {
            if (nums[i] > nums[ind]) {

                int temp = nums[i];
                nums[i] = nums[ind];
                nums[ind] = temp;

                break;
            }
        }

        // Step 3: Reverse remaining part
        reverse(nums, ind + 1, n - 1);
    }

    private void reverse(int[] nums, int left, int right) {

        while (left < right) {

            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}