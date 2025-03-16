/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public boolean isLeftRight(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return false;
        if((p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val))
            return true;

        if(p == root || q == root)
            return true;
        return false;
    }
    
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        while(curr != null) {
            if(isLeftRight(curr, p, q))
                return curr;
            else if(p.val < curr.val && q.val < curr.val)
                curr = curr.left;
            else
                curr = curr.right;
        }
        return null;
        
    }
}
