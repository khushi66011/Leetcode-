class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) {
            return ans;
        }

        String[] map = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        backtrack(0, digits, "", map, ans);

        return ans;
    }

    public void backtrack(int index, String digits, String current,
                          String[] map, List<String> ans) {

        // All digits are processed
        if (index == digits.length()) {
            ans.add(current);
            return;
        }

        // Get letters for current digit
        String letters = map[digits.charAt(index) - '0'];

        // Try every possible letter
        for (char ch : letters.toCharArray()) {

            // Choose
            // Move to next digit
            backtrack(index + 1, digits, current + ch, map, ans);

            // No explicit undo needed because String is immutable
        }
    }
}