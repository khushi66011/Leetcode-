class Solution {
    public int maxProduct(int[] nums) {

        int maxEnding = nums[0];
        int minEnding = nums[0];
        int answer = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int temp = maxEnding;

            maxEnding = Math.max(nums[i],
                    Math.max(maxEnding * nums[i],
                             minEnding * nums[i]));

            minEnding = Math.min(nums[i],
                    Math.min(temp * nums[i],
                             minEnding * nums[i]));

            answer = Math.max(answer, maxEnding);
        }

        return answer;
    }
}