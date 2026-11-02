import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];

        solve(nums, vis, new ArrayList<>(), ans);

        return ans;
    }

    public void solve(int[] nums, boolean[] vis,
                      List<Integer> temp, List<List<Integer>> ans) {

        // If all elements are used, store the permutation
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (!vis[i]) {

                vis[i] = true;
                temp.add(nums[i]);

                solve(nums, vis, temp, ans);

                // Backtracking
                temp.remove(temp.size() - 1);
                vis[i] = false;
            }
        }
    }
}