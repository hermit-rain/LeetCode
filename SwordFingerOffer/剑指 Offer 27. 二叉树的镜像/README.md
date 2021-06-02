# [剑指 Offer 27. 二叉树的镜像](https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/)

## 题目描述

请完成一个函数，输入一个二叉树，该函数输出它的镜像。

例如输入：

**示例 1：**

```
     4
   /   \
  2     7
 / \   / \
1   3 6   9
```

**镜像输出：**

```
     4
   /   \
  7     2
 / \   / \
9   6 3   1
```

## 解题思路

- 解法一：递归，我们可以发现镜像二叉树可以通过将原二叉树中的任意一个节点的左右两棵子树进行交换得到。通过递归逐渐从下到上逐一的将以非叶子节点为根节点的子树中的左右子树交换即可。


## 代码

<!-- tabs:start -->

### **Java**

```java
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }
}
```


### **...**

```

```

<!-- tabs:end -->