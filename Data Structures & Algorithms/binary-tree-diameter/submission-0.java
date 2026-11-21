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
    private int max = 0;

    public int height(TreeNode node) {
         if (node == null) return 0;

        int right, left;
        right = height(node.right);
        left = height(node.left);

        max = Math.max(max, left+right);
        return 1+Math.max(right, left);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return max;
    }

}
