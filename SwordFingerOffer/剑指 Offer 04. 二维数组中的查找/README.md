# [剑指 Offer 04. 二维数组中的查找](https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/)

## 题目描述

在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

**示例 1：**

现有矩阵 matrix 如下：

```
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
```

给定 target = `5`，返回 `true`。

给定 target = `20`，返回 `false`。

**限制：**

```
0 <= n <= 1000
0 <= m <= 1000
```

## 解题思路

- 解法一：暴力遍历，全盘遍历二维数组，如果找到则直接返回true即可。

- 解法二：线性查找，因为二维数组中从上到下，从左到右都是依次递增的，根据这一性质，我们可以发现暴力遍历绝不是最优解。通过观察我们不难发现，在二维数组的矩阵的拐点上，如 15，12，9，13，18，这样在矩阵对角线上的点。它们有一个共性即将以其为拐点的行和列串联起来就是一个线性增长的序列，如[1,4,7,11,15,19,22,24,30]。

  根据这一性质，我们可以从二维矩阵的右上角开始向矩阵的左下脚开始线性搜索(当然也可以从左下到右上进行搜索)，判断拐点值与目标元素的关系，如果相等即返回，如果大于目标值则说明目标元素在该拐点左侧，则排除该列并向左搜索，如果小于目标元素，则说明目标元素在该拐点下面，则排除该行，向下搜索。如此不断从右上到左下每次判断则减少一行或一列，当找到目标值直接返回即可。


## 代码

<!-- tabs:start -->

### **Java**

**解法一**

```java
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
```

**解法二**

```java
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int i = 0, j = matrix[0].length - 1;
        while (j >= 0 && i < matrix.length) {
            if (matrix[i][j] > target) j--;
            else if (matrix[i][j] < target) i++;
            else return true;
        }
        return false;
    }
}
```


### **...**

```

```

<!-- tabs:end -->