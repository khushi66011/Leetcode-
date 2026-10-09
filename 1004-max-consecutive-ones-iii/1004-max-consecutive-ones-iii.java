class Solution {
    public int longestOnes(int[] nums, int k) {
        int  left =0;
        int zeroes=0;
        int ans=0;
        for(int right = 0; right<nums.length; right++){
            if(nums[right] == 0) zeroes++;
            while(zeroes > k){
                if(nums[left] == 0)
                  zeroes--;
                  left++;

            }   
            ans = Math.max(ans, right-left+1);
            
        }
        return ans;
    }
}

/*- Index 0 par 1 hai, toh zero count same rahega.
- Index 1 par 0 hai, toh zeroes-- hoga.
- Ab left = 2, aur window valid hai.
Final answer: 4
4. Interview mein kaise explain karein?
“We use the sliding window technique. The right pointer expands the window, and we count the zeroes. Whenever the number of zeroes exceeds k, we move the left pointer forward until the window becomes valid. For every valid window, we update the maximum length.”
Complexity:
- Time: \(O(n)\), kyunki dono pointers maximum n times move karte hain.
- Space: \(O(1)\), kyunki sirf a few variables use kiye hain.
*/