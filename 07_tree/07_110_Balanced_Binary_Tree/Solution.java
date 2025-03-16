class Solution {
    public int[] helper(TreeNode root) {
        if (root == null) {
            return new int[] { 0, 1 };
        }
        int[] left_tree = helper(root.left);
        int[] right_tree = helper(root.right);
        boolean balanced = (left_tree[1] == 1 && 
                            right_tree[1] == 1 && 
                            Math.abs(left_tree[0] - right_tree[0]) <= 1);
        int height = 1 + Math.max(left_tree[0], right_tree[0]);
        return new int[]{height, balanced ? 1 : 0};

    }

    public boolean isBalanced(TreeNode root) {
        return helper(root)[1] == 1;
    }
}
