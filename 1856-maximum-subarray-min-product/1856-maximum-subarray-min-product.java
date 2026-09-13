class Solution {
    public int maxSumMinProduct(int[] nums) {

        int n = nums.length;

        // Prefix sum array
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();

        // Find previous smaller element
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = st.peek();
            }

            st.push(i);
        }

        st.clear();

        // Find next smaller element
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = st.peek();
            }

            st.push(i);
        }

        long ans = 0;

        // Calculate min * sum for every possible minimum
        for (int i = 0; i < n; i++) {

            // Sum of subarray from left[i]+1 to right[i]-1
            long sum = prefix[right[i]] - prefix[left[i] + 1];

            // nums[i] is the minimum of this subarray
            long product = sum * nums[i];

            ans = Math.max(ans, product);
        }

        return (int) (ans % 1000000007);
    }
}