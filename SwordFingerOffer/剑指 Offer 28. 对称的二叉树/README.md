# [剑指 Offer 28. 对称的二叉树](https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/)

## 题目描述

请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。

二叉树 [1,2,2,3,4,4,3] 是对称的。

```
    1
   / \
  2   2
 / \ / \
3  4 4  3
```

但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

```
    1
   / \
  2   2
   \   \
   3    3
```

**示例 1：**

```
输入：root = [1,2,2,3,4,4,3]
输出：true
```

**示例 2：**

```
输入：root = [1,2,2,null,3,null,3]
输出：false
```

**限制：**

```
0 <= 节点个数 <= 1000
```

## 解题思路

- 解法一：递归，本题我们要想判断该二叉树是否为对称二叉树，我们只需要判断两棵子树是否对称即可。我们自定义一个判断两棵树是否对称的方法；要想判断两棵树是否对称需要判断1.两棵树的根节非空且相等；2.该树的左子树等于另一颗树的右子树；3.该树的右子树等于另一颗树的左子树；其中对于左右子树的对称判断我们递归判断即可。

## 代码

<!-- tabs:start -->

### **Java**

```java
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
```


### **...**

```

```

<!-- tabs:end -->