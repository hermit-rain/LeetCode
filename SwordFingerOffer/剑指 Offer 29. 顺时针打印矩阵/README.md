# [剑指 Offer 29. 顺时针打印矩阵](https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/)

## 题目描述

输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

**示例 1：**

```
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
```

**示例 2：**

```
输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
```

**限制：**

```
0 <= matrix.length <= 100
0 <= matrix[i].length <= 100
```

## 解题思路

- 解法一：设定边界

  顺时针打印矩阵的顺序是 **“从左向右、从上向下、从右向左、从下向上”** 循环，因此我们可以设定矩阵的**“左、上、右、下”**四个边界来模拟矩阵遍历的顺序。定义一个矩阵行*列大小的数组来接收矩阵的元素并返回。从左向右->上边界向下内缩，从上向下->右边界向左内缩，从右向左->下边界向上内缩，从下向上->左边界向右内缩~~。当边界相遇越界后即退出循环，此时打印结束。

  | 打印方向 | 根据边界打印       | 边界向内收缩  | 是否打印完毕 |
  | -------- | ------------------ | ------------- | ------------ |
  | 从左向右 | 左边界l ，右边界 r | 上边界 t 加 1 | t > b        |
  | 从上向下 | 上边界 t ，下边界b | 右边界 r 减 1 | l > r        |
  | 从右向左 | 右边界 r ，左边界l | 下边界 b 减 1 | t > b        |
  | 从下向上 | 下边界 b ，上边界t | 左边界 l 加 1 | l > r        |

## 代码

<!-- tabs:start -->

### **Java**

```java
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;  
        int[] res = new int[(r + 1) * (b + 1)]; 
        int index = 0; 
        while (true) {
            for (int i = l; i <= r; i++) { 
                res[index] = matrix[t][i];
                index++;
            }
            if (++t > b) break;
            for (int i = t; i <= b; i++) {
                res[index] = matrix[i][r];
                index++;
            }
            if (l > --r) break;
            for (int i = r; i >= l; i--) {
                res[index] = matrix[b][i];
                index++;
            }
            if (t > --b) break;
            for (int i = b; i >= t; i--) { 
                res[index] = matrix[i][l];
                index++;
            }
            if (++l > r) break;
        }
        return res;
    }
}
```


### **...**

```

```

<!-- tabs:end -->