class Solution {

    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {

        int n = s.length();

        // count of non-zero digits till index i
        int[] nonZeroCount = new int[n + 1];

        // sum of non-zero digits till index i
        long[] digitSum = new long[n + 1];

        // store all non-zero digits
        ArrayList<Integer> digits = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';

            nonZeroCount[i + 1] = nonZeroCount[i];
            digitSum[i + 1] = digitSum[i];

            if (d != 0) {
                nonZeroCount[i + 1]++;
                digitSum[i + 1] += d;
                digits.add(d);
            }
        }

        int k = digits.size();

        long[] hash = new long[k + 1];
        long[] pow10 = new long[k + 1];

        pow10[0] = 1;

        for (int i = 1; i <= k; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
            hash[i] = (hash[i - 1] * 10 + digits.get(i - 1)) % MOD;
        }

        int[] ans = new int[queries.length];

        for (int qi = 0; qi < queries.length; qi++) {

            int l = queries[qi][0];
            int r = queries[qi][1];

            // indices in non-zero digit sequence
            int leftIndex = nonZeroCount[l];
            int rightIndex = nonZeroCount[r + 1];

            int len = rightIndex - leftIndex;

            long x = (hash[rightIndex]
                    - (hash[leftIndex] * pow10[len]) % MOD
                    + MOD) % MOD;

            long sum = digitSum[r + 1] - digitSum[l];

            ans[qi] = (int) ((x * (sum % MOD)) % MOD);
        }

        return ans;
    }
}