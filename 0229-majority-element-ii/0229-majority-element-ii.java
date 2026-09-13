class Solution {
    public List<Integer> majorityElement(int[] nums) {

        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;

        // Find two possible candidates
        for (int num : nums) {

            if (num == candidate1) {
                count1++;
            }
            else if (num == candidate2) {
                count2++;
            }
            else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            }
            else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            }
            else {
                count1--;
                count2--;
            }
        }

        // Verify the actual frequency of candidates
        count1 = 0;
        count2 = 0;

        for (int num : nums) {

            if (num == candidate1) {
                count1++;
            }
            else if (num == candidate2) {
                count2++;
            }
        }

        List<Integer> ans = new ArrayList<>();

        // Check if candidate1 appears more than n/3 times
        if (count1 > nums.length / 3) {
            ans.add(candidate1);
        }

        // Check if candidate2 appears more than n/3 times
        if (count2 > nums.length / 3) {
            ans.add(candidate2);
        }

        return ans;
    }
}