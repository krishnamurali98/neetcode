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
class Solution1 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        ArrayDeque<Boolean> visited = new ArrayDeque<>();

        stack.push(root);
        visited.push(false);

        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            boolean visit = visited.pop();
            if(curr != null) {
                if(visit) {
                    ans.add(curr.val);
                } else {
                    stack.push(curr);
                    visited.push(true);
                    if(curr.right != null) {
                        stack.push(curr.right);
                        visited.push(false);
                    }
                    if(curr.left != null) {
                        stack.push(curr.left);
                        visited.push(false);
                    }     
                }
            }
        }
        return ans;
    }
}
