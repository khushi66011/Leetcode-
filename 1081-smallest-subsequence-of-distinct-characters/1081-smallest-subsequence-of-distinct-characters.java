class Solution {
    public String smallestSubsequence(String s) {

        int[] last = new int[26];

        // Last occurrence of each character
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        boolean[] used = new boolean[26];

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Skip duplicates
            if (used[ch - 'a'])
                continue;

            // Remove bigger characters
            // if they can appear later again
            while (!st.isEmpty()
                    && st.peek() > ch
                    && last[st.peek() - 'a'] > i) {

                used[st.pop() - 'a'] = false;
            }

            st.push(ch);
            used[ch - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder();

        for (char ch : st)
            ans.append(ch);

        return ans.toString();
    }
}