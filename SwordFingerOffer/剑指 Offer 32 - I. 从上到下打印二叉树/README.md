# [剑指 Offer 32 - I. 从上到下打印二叉树](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/)

## 题目描述

从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

**示例 1：**

给定二叉树: `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```

**返回：**

```
[3,9,20,15,7]
```

**提示：**

```
节点总数 <= 1000
```

## 解题思路

- 解法一：队列，本题为水平打印二叉树，不同于前序等遍历，我们没办法通过递归的形式来控制遍历顺序。为了保证打印的顺序我们利用队列这一数据结构。先将根节点入队列，然会执行出队操作，每次出队列就记录其值，然后将其左右孩子入队列，这样就保证了每次打印完一行后，队列的头部元素都是下一行的起始节点。任意节点出队列都执如上动作，当队列为空时即打印完毕。


## 代码

<!-- tabs:start -->

### **Java**

```java
class Solution {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
```


### **...**

```

```

<!-- tabs:end -->