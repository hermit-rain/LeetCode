# [剑指 Offer 10- I. 斐波那契数列](https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/)

## 题目描述

写一个函数，输入 `n` ，求斐波那契（Fibonacci）数列的第 `n` 项（即 `F(N)`）。斐波那契数列的定义如下：

```
F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
```

斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

**示例 1：**

```
输入：n = 2
输出：1
```

**示例 2：**

```
输入：n = 5
输出：5
```

**提示：**

```
0 <= n <= 100
```

## 解题思路

- 解法一：最优解-动态规划，以斐波那契数列性质 f(n + 1) = f(n) + f(n - 1) 为转移方程。
- 解法二：记忆化递归法，在递归的基础上创建一个扩展数组，递归创建斐波那契数列并存储子在数组中，缺点是需要额外消化O(N)的空间。

## 代码

<!-- tabs:start -->

### **Java**

**解法一**

```java
class Solution {
    public int fib(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
```

**解法二**

```java
class Solution {
    public int fib(int n) {
        int[] f = new int[n + 2];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = (f[i - 1] + f[i - 2]) % 1000000007;
        }
        return f[n];
    }
}
```

### **...**

```

```

<!-- tabs:end -->