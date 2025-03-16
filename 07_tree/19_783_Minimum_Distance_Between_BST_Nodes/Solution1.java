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
    public void inorder(TreeNode root, ArrayList<Integer> ans) {
        if(root != null) {
            inorder(root.left, ans);
            ans.add(root.val);
            inorder(root.right, ans);
        }
    }

    public int minDiffInBST(TreeNode root) {
        if(root == null)
            return 0;
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root, arr);

        int minDiff = Integer.MAX_VALUE;    
        for(int i=1;i<arr.size();i++) {
            minDiff = Math.min(minDiff, arr.get(i)-arr.get(i-1));
        }
        return minDiff;
    }
}
