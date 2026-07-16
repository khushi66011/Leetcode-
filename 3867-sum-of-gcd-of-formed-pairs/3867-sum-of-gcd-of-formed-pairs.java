class Solution {

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public long gcdSum(int[] nums) {

        int n = nums.length;

        int[] prefixGcd = new int[n];

        int mx = 0;

        // Construct prefixGcd array
        for (int i = 0; i < n; i++) {

            mx = Math.max(mx, nums[i]);

            prefixGcd[i] = gcd(nums[i], mx);
        }

        // Sort
        Arrays.sort(prefixGcd);

        long ans = 0;

        int left = 0;
        int right = n - 1;

        // Form pairs
        while (left < right) {

            ans += gcd(prefixGcd[left],
                       prefixGcd[right]);

            left++;
            right--;
        }

        return ans;
    }
}