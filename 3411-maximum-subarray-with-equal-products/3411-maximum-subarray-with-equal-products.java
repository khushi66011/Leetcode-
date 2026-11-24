class Solution {
    public int maxLength(int[] nums) {

        int n = nums.length;
        int ans = 0;

        int max = 0;
        int ml = 1;

        // Find maximum element and LCM of complete array
        for (int x : nums) {
            max = Math.max(max, x);
            ml = lcm(ml, x);
        }

        int maxP = ml * max;

        // Generate all subarrays
        for (int i = 0; i < n; i++) {

            int p = 1;
            int g = 0;
            int l = 1;

            for (int j = i; j < n; j++) {

                p *= nums[j];

                g = gcd(g, nums[j]);

                l = lcm(l, nums[j]);

                // Check product equivalent condition
                if (p == g * l) {
                    ans = Math.max(ans, j - i + 1);
                }

                // Stop if product exceeds maximum possible limit
                if (p > maxP) {
                    break;
                }
            }
        }

        return ans;
    }

    // GCD function
    private int gcd(int a, int b) {

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    // LCM function
    private int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
}
