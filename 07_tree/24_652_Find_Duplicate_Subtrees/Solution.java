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
    public String preorder(TreeNode node, List<TreeNode> ans, HashMap<String, Integer> hm) {
        if(node == null) 
            return "null";
        String serialized = node.val + "," + 
                            preorder(node.left, ans, hm) + "," + 
                            preorder(node.right, ans, hm);
        hm.put(serialized, hm.getOrDefault(serialized, 0)+1);

        if(hm.get(serialized) == 2)
            ans.add(node);
        
        return serialized;
    }


    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap<>();
        
        preorder(root, ans, hm);
        return ans;
    }
}
