# [剑指 Offer 34. 二叉树中和为某一值的路径](https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/)

## 题目描述

输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。

**示例 1：**
给定如下二叉树，以及目标和 `target = 22`，

```
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
```

**返回：**

```
[
   [5,4,11,2],
   [5,8,4,5]
]
```

**提示：**

```
节点总数 <= 10000
```

## 解题思路

- 解法一：先序遍历；回溯，本题我们需要统计二叉树中和为某一值的所有路径。我们进行先序的递归遍历，在遍历的过程中将符合判决条件的路径加入到集合中即可，注意回溯的条件->**每次回溯都要移除”路径集合“中的最后一个元素**


## 代码

<!-- tabs:start -->

### **Java**

```java
class Solution {
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        myPathSum(root, target);
        return res;
    }

    public void myPathSum(TreeNode root, int target) {
        if (root == null) return;
        path.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList<>(path));
        }
        myPathSum(root.left, target);
        myPathSum(root.right, target);
        path.removeLast();
    }
}
```


### **...**

```

```

<!-- tabs:end -->
