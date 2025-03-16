/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int helper(TreeNode root, int[] maxAns) {
        if(root == null)
            return 0;
        int height_left = helper(root.left, maxAns);
        int height_right = helper(root.right, maxAns);
        maxAns[0] = Math.max(maxAns[0], height_left + height_right);
        return 1 + Math.max(height_left, height_right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxAns = new int[1];
        helper(root, maxAns);
        return maxAns[0];
    }
}
