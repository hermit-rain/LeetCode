# [剑指 Offer 55 - II. 平衡二叉树](https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/)

## 题目描述

输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。

**示例 1：**

给定二叉树 `[3,9,20,null,null,15,7]`

```
    3
   / \
  9  20
    /  \
   15   7
```

返回 `true` 。

**示例 2：**

```
       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
```

返回 `false` 。

**限制：**

```
0 <= 树的结点个数 <= 10000
```

## 解题思路

- 解法一：递归，本题同 [剑指 Offer 55 - I. 二叉树的深度](https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/) 本质上都是求二叉树的深度。判断树是不是平衡二叉树，只需要同时满足 1.以当前节点为根节点的两棵子树的深度差是否小于等于1；2.左子树是不是平衡二叉树；3.右子树是不是平衡二叉树，这三个条件。其中左右子树的平衡判断同根节点相同所以直接递归判断即可。


<!-- tabs:start -->

### **Java**

```java
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
```


### **...**

```

```

<!-- tabs:end -->