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
    //全局哈希表 => 存储中序结果数组中 值与索引的映射关系
    private Map<Integer, Integer> indexMap;

    /**
     * 根据二叉树的前序及中序遍历结果建立二叉树
     *
     * @param pre 前序遍历结果数组
     * @param in 中序遍历结果数组
     * @param pre_left 前序遍历(子树)的左边界
     * @param pre_right 前序遍历(子树)的右边界
     * @param in_left 中序遍历(子树)的左边界
     * @param in_right 中序遍历(子树)的右边界
     * @return 返回创建二叉树的根节点
     */
    public TreeNode myBuildTree(int[] pre, int[] in, int pre_left, int pre_right, int in_left, int in_right) {
        //递归终止的条件
        if (pre_left > pre_right) {
            return null;
        }
        //确定根节点 => 前序遍历的左边界即为根节点
        int pre_root  = pre_left;
        //根据 根节点 的值返回其在中序结果数组中的索引下标
        int in_root = indexMap.get(pre[pre_root]);
        //创建根节点
        TreeNode root = new TreeNode(pre[pre_root]);
        //根据根节点在中序结果数组中的下标返回左子树的长度 => 辅助确定左右子树的边界
        int sizeLeftSubtree = in_root - in_left;
        //更新左右边界递归创建左子树
        root.left = myBuildTree(pre, in, pre_left + 1, pre_left + sizeLeftSubtree, in_left, in_root - 1);
        //更新左右边界递归创建右子树
        root.right = myBuildTree(pre, in, pre_left + sizeLeftSubtree + 1, pre_right, in_root + 1, in_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>();
        //创建哈希表
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        //调用重建二叉树方法返回其根节点
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

}