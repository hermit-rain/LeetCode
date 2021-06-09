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
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        if (recur(A, B)) return true;
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    /**
     * 判断树 A 中以任一个节点为根的子树是否和 树 B 相同
     *
     * @param A 树A 中的任意节点
     * @param B 树B 的根节点
     * @return 如果相同则返回true 否则返回 false
     */
    public boolean recur(TreeNode A, TreeNode B) {
        //递归退出的条件
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        //递归判断A，B 的左子树及右子树
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

}