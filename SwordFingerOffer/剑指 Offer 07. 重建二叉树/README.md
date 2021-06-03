# [剑指 Offer 07. 重建二叉树](https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/)

## 题目描述

输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

**示例 1：**

```
前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
```

**返回如下的二叉树：**

```
    3
   / \
  9  20
    /  \
   15   7
```

**限制：**

```
0 <= 节点个数 <= 5000
```

## 解题思路

- 解法一：递归

对于任意一颗二叉树其前序遍历的结果的格式：

```
[根节点，[左子树的前序遍历结果]，[右子树的前序遍历结果]]
```

中序遍历的结果格式：

```
[[左子树的中序遍历结果]，根节点，[右子树的中序遍历结果]]
```

首先根据前序遍历的起始值我们就可以确定整棵树的根节点，通过根节点找到其在中序遍历结果集中的下标，进而知道该二叉树的左右子树的节点个数。由于任一颗二叉树其前序、中序遍历的结果集的个数相同，所以我们就可以通过在中序结果集中获取的左右子树的长度得到其在前序遍历结果集合中对应的边界索引。知道该二叉树的左右子树的前序遍历结果对应的结果集合边界后，我们就直接递归地创建左右子树并连接到根节点即可。递归形式如下：

```
[根节点，
[左子树的根节点，[左子树的左子树的前序遍历结果]，[左子树的右子树的前序遍历结果]]，
[右子树的根节点，[右子树的左子树的前序遍历结果]，[右子树的右子树的前序遍历结果]]]
```

**注意：**

避免每次全盘扫描确认“根节点”在中序遍历结果集中的索引，我们创建全局哈希表存储 中序结果集中值与下标的映射关系

## 代码

<!-- tabs:start -->

### **Java**

```java
class Solution {
    private Map<Integer, Integer> indexMap;

    /**
     * 根据二叉树的前序及中序遍历结果建立二叉树
     *
     * @param pre       前序遍历结果数组
     * @param in        中序遍历结果数组
     * @param pre_left  前序遍历(子树)的左边界
     * @param pre_right 前序遍历(子树)的右边界
     * @param in_left   中序遍历(子树)的左边界
     * @param in_right  中序遍历(子树)的右边界
     * @return 返回创建二叉树的根节点
     */
    public TreeNode myBuildTree(int[] pre, int[] in, int pre_left, int pre_right, int in_left, int in_right) {
        if (pre_left > pre_right) {
            return null;
        }
        int pre_root = pre_left;
        int in_root = indexMap.get(pre[pre_root]);
        TreeNode root = new TreeNode(pre[pre_root]);
        int sizeLeftSubtree = in_root - in_left;
        root.left = myBuildTree(pre, in, pre_left + 1, pre_left + sizeLeftSubtree, in_left, in_root - 1);
        root.right = myBuildTree(pre, in, pre_left + sizeLeftSubtree + 1, pre_right, in_root + 1, in_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }
}
```


### **...**

```

```

<!-- tabs:end -->