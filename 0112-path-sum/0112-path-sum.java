/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {

        // Tree empty hai
        if (root == null) {
            return false;
        }

        // Leaf node par check karo
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        // Remaining target sum
        int remaining = targetSum - root.val;

        // Left ya right kisi bhi path ka sum target tak pahunchna chahiye
        return hasPathSum(root.left, remaining) ||
               hasPathSum(root.right, remaining);
    }
}