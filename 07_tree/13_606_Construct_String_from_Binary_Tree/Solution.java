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
    public void helper(TreeNode root, StringBuilder sb) {
        if(root == null)
            return;
        sb.append("(");
        sb.append(String.valueOf(root.val));

        if(root.left == null && root.right != null)
            sb.append("()");

        helper(root.left, sb);
        helper(root.right, sb);

        sb.append(")");
    }

    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return sb.toString().substring(1, sb.length()-1);
    }
}
