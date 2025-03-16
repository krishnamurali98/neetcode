class Solution2 {
    public int helper(TreeNode root, boolean[] result) {
        if (root == null) {
            return 0;
        }
        int left_tree = helper(root.left, result);
        int right_tree = helper(root.right, result);
        if (Math.abs(left_tree - right_tree) > 1) {
            result[0] = false;
        }
        return 1 + Math.max(left_tree, right_tree);

    }

    public boolean isBalanced(TreeNode root) {
        boolean[] result = new boolean[1];
        result[0] = true;

        helper(root, result);
        
        return result[0];
    }
}
