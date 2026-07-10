class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // Find next greater for every element in nums2
        for (int i = nums2.length - 1; i >= 0; i--) {

            while (!st.isEmpty() &&
                    st.peek() <= nums2[i]) {
                st.pop();
            }

            int next = st.isEmpty() ? -1 : st.peek();

            map.put(nums2[i], next);

            st.push(nums2[i]);
        }

        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}