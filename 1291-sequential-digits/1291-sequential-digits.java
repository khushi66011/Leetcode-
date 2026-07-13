class Solution {
    public List<Integer> sequentialDigits(int low, int high) {

        // Stores all valid sequential numbers
        List<Integer> ans = new ArrayList<>();

        // All sequential numbers can be formed from this string
        String s = "123456789";

        // len = length of the sequential number
        // Minimum length is 2 because single digit numbers
        // are not considered sequential
        for (int len = 2; len <= 9; len++) {

            // Generate all substrings of size 'len'
            for (int start = 0; start + len <= 9; start++) {

                // Extract substring
                // Example: "123", "234", "3456"
                String sub = s.substring(start, start + len);

                // Convert substring into integer
                int num = Integer.parseInt(sub);

                // Add only if it lies in the range [low, high]
                if (num >= low && num <= high) {
                    ans.add(num);
                }
            }
        }

        return ans;
    }
}