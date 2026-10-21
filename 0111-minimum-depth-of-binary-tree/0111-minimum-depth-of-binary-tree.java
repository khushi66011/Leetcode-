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
    public int minDepth(TreeNode root) {

        // Tree empty hai
        if (root == null) {
            return 0;
        }

        // Leaf node
        if (root.left == null && root.right == null) {
            return 1;
        }

        // Agar left subtree nahi hai
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }

        // Agar right subtree nahi hai
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        // Dono children present hain
        return 1 + Math.min(
            minDepth(root.left),
            minDepth(root.right)
        );
    }
}