# [135. 分发糖果](https://leetcode-cn.com/problems/candy/)

## 题目描述	

老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。

你需要按照以下要求，帮助老师给这些孩子分发糖果：

每个孩子至少分配到 1 个糖果。
评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
那么这样下来，老师至少需要准备多少颗糖果呢？

**示例 1：**

```
输入：[1,0,2]
输出：5
解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。
```

**示例 2：**

```
输入：[1,2,2]
输出：4
解释：你可以分别给这三个孩子分发 1、2、1 颗糖果。第三个孩子只得到 1 颗糖果，这已满足上述两个条件.
```

## 解题思路

#### 解法一  前后两次遍历

题目要求**评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果**，返回**至少**需要多少个糖果；

我们定义一个孩子总数大小 的数组来存储每个孩子需要的糖果数来辅助遍历

**第一次-> 从前到后遍历**

- 当`ratings[i] > ratings[i - 1]` 时该孩子的糖果数在前面孩子的基础上 +1；

**第二次-> 从后向前遍历**

- 当`ratings[i] > ratings[i + 1] && res[i] <= res[i + 1]`时，该孩子糖果数在后面孩子的基础上 +1，其中`res[i] <= res[i + 1]` 用来消除加多的情况；
- 同时用sum 统计 辅助数组中的所有糖果数

最后更新 sum 并返回即可；

## 代码

<!-- tabs:start -->

#### Java

**解法一**

```java
class Solution {
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int sum = 0;
        int[] res = new int[n];
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                res[i] = res[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && res[i] <= res[i + 1]) {
                res[i] = res[i + 1] + 1;
            }
            sum += res[i];
        }
        sum += res[n - 1] + res.length;
        return sum;
    }

}
```

### **...**

```

```

<!-- tabs:end -->