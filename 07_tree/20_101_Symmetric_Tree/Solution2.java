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
    public boolean helper(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        if(p == null || q == null || p.val != q.val)
            return false;
        return helper(p.left, q.right) && helper(p.right, q.left);
    }

    public boolean isSymmetric(TreeNode root) {
        TreeNode left_tree = root.left;
        TreeNode right_tree = root.right;

        return helper(left_tree, right_tree);
    }
}
