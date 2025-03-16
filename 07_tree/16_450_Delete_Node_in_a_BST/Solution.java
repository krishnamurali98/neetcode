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
    public int successor(TreeNode curr) {
        while(curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr != null ? curr.val : -1;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;
        if(root.val == key) {
            if(root.left != null && root.right != null) {
                int newKey = successor(root.right);
                root.val = newKey;
                root.right = deleteNode(root.right, newKey); 
            }
            else if(root.left == null)
                return root.right;
            else
                return root.left;
        }
        if(root.val < key)
            root.right = deleteNode(root.right, key);
        else
            root.left = deleteNode(root.left, key);
        return root;

    }
}
