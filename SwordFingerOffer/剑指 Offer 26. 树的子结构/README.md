# [剑指 Offer 26. 树的子结构](https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/)

## 题目描述

输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)

B是A的子结构， 即 A中有出现和B相同的结构和节点值。

给定的树 A:

```
     3
    / \
   4   5
  / \
 1   2
```

给定的树 B：

```
   4 
  /
 1
```

返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。

**示例 1：**

```
输入：A = [1,2,3], B = [3,1]
输出：false
```

**示例 2：**

```
输入：A = [3,4,5,1,2], B = [4,1]
输出：true
```

**限制：**

```
0 <= 节点个数 <= 10000
```

## 解题思路

- 解法一：递归；先序遍历，判断树B是否为树A的子结构，我们只需要先序的遍历树A中的任一个节点并与树B 进行比较判断两棵树是否相同即可。这样我们就需要再写一个用来判断**以任意节点为根节点的两棵子树是否相同**的递归方法。

**recur(TreeNode A, TreeNode B) 方法设计**

|                    | **1.当B节点为空，说明B已经全部匹配完成 ，返回true**          |
| ------------------ | ------------------------------------------------------------ |
| **递归终止的条件** | **2.当A节点为空，说明已经越过A叶子节点，匹配失败，返回 false** |
|                    | **3.当节点A与B的值不同时，匹配失败，返回 false**             |
| **返回值（递归）** | **1.递归判断A与B 的左子树是否相同 recur(A.left, B.left)**    |
|                    | **2.递归判断A与B 的右子树是否相同 recur(A.right, B.right)**  |



## **代码**

**<!-- tabs:start -->**

### **Java**

```java
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        if (recur(A, B)) return true;
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean recur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
```


### **...**

```

```

**<!-- tabs:end -->**