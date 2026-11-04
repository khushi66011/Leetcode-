class Solution {

    class MedianWindow {
        TreeMap<Integer, Integer> lower = new TreeMap<>();
        TreeMap<Integer, Integer> upper = new TreeMap<>();

        int ls = 0, us = 0;
        long lsum = 0, usum = 0;

        void addMap(TreeMap<Integer, Integer> map, int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        void removeMap(TreeMap<Integer, Integer> map, int val) {
            int count = map.get(val);
            if (count == 1) map.remove(val);
            else map.put(val, count - 1);
        }

        void add(int val) {
            if (lower.isEmpty() || val <= lower.lastKey()) {
                addMap(lower, val);
                ls++;
                lsum += val;
            } else {
                addMap(upper, val);
                us++;
                usum += val;
            }
            balance();
        }

        void remove(int val) {
            if (lower.containsKey(val)) {
                removeMap(lower, val);
                ls--;
                lsum -= val;
            } else {
                removeMap(upper, val);
                us--;
                usum -= val;
            }
            balance();
        }

        void balance() {
            int target = (ls + us + 1) / 2;

            while (ls > target) {
                int val = lower.lastKey();
                removeMap(lower, val);
                ls--;
                lsum -= val;

                addMap(upper, val);
                us++;
                usum += val;
            }

            while (ls < target) {
                int val = upper.firstKey();
                removeMap(upper, val);
                us--;
                usum -= val;

                addMap(lower, val);
                ls++;
                lsum += val;
            }
        }

        long cost() {
            long median = lower.lastKey();

            return median * ls - lsum
                 + usum - median * us;
        }
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;
        int m = n - x + 1;

        // Calculate cost of every window
        long[] cost = new long[m];

        MedianWindow window = new MedianWindow();

        for (int i = 0; i < x; i++) {
            window.add(nums[i]);
        }

        cost[0] = window.cost();

        for (int i = x; i < n; i++) {
            window.remove(nums[i - x]);
            window.add(nums[i]);

            cost[i - x + 1] = window.cost();
        }

        // DP: minimum cost to select exactly j windows
        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[n + 1][k + 1];

        for (long[] row : dp) {
            Arrays.fill(row, INF);
        }

        dp[0][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {

                if (dp[i][j] == INF) continue;

                // Skip current position
                dp[i + 1][j] = Math.min(
                    dp[i + 1][j], dp[i][j]
                );

                // Select window of size x
                if (j < k && i + x <= n) {
                    dp[i + x][j + 1] = Math.min(
                        dp[i + x][j + 1],
                        dp[i][j] + cost[i]
                    );
                }
            }
        }

        return dp[n][k];
    }
}
