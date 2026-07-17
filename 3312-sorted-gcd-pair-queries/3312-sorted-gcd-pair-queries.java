class Solution {

    public int[] gcdValues(int[] nums, long[] queries) {

        int mx = 0;

        for (int x : nums)
            mx = Math.max(mx, x);

        int[] freq = new int[mx + 1];

        for (int x : nums)
            freq[x]++;

        long[] gcdCnt = new long[mx + 1];

        // Count pairs having exact gcd = g
        for (int g = mx; g >= 1; g--) {

            long cnt = 0;

            for (int j = g; j <= mx; j += g)
                cnt += freq[j];

            long pairs = cnt * (cnt - 1) / 2;

            for (int j = g + g; j <= mx; j += g)
                pairs -= gcdCnt[j];

            gcdCnt[g] = pairs;
        }

        // Prefix count
        long[] pref = new long[mx + 1];

        for (int i = 1; i <= mx; i++)
            pref[i] = pref[i - 1] + gcdCnt[i];

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            long q = queries[i] + 1;

            int left = 1;
            int right = mx;

            while (left < right) {

                int mid = left + (right - left) / 2;

                if (pref[mid] >= q)
                    right = mid;
                else
                    left = mid + 1;
            }

            ans[i] = left;
        }

        return ans;
    }
}