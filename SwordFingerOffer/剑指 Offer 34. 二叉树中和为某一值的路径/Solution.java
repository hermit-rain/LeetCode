/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    //定义全局变量 res 做返回值
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        myPathSum(root, target);
        return res;
    }

    /**
     * 递归回溯 统计每一条符合条件的路径
     *
     * @param root   二叉树的根节点
     * @param target 判决条件-路径的和
     */
    public void myPathSum(TreeNode root, int target) {
        //递归退出的条件
        if (root == null) return;
        path.add(root.val);
        target -= root.val;
        //如果路径的和符合判决条件则添加至返回值集合
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList<>(path));
        }
        //先序遍历左右子树
        myPathSum(root.left, target);
        myPathSum(root.right, target);
        //回溯操作
        path.removeLast();
    }
}