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
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : isSymmetricForTwoTree(root.left,root.right);
    }

    boolean isSymmetricForTwoTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null || t1.val != t2.val) return false;
        return isSymmetricForTwoTree(t1.left, t2.right) && isSymmetricForTwoTree(t1.right, t2.left);
    }
}