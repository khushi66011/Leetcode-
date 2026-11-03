import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    void solve(int index, int[] arr, int target,
               List<Integer> list, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (index == arr.length || target < 0)
            return;

        // Pick
        list.add(arr[index]);
        solve(index, arr, target - arr[index], list, ans);

        // Backtrack
        list.remove(list.size() - 1);

        // Not Pick
        solve(index + 1, arr, target, list, ans);
    }
}