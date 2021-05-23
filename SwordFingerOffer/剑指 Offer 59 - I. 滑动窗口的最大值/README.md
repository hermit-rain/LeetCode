# [剑指 Offer 59 - I. 滑动窗口的最大值](https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/)

## 题目描述

给定一个数组 `nums` 和滑动窗口的大小 `k`，请找出所有滑动窗口里的最大值。

**示例 1：**

```
输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7] 
解释: 

  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
```

**说明：**

```
你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
```

## 解题思路

- 解法一：双端队列，本题与[剑指 Offer 59 - II. 队列的最大值](https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/)相似，我们首先想到可以直接先调用已经实现好的可以返回队列最大值的数据结构来完成，但是该可返回队列最大值方法的底层由两个队列实现，速度太慢，而且本题我们只是需要返回结果集数组即可并不需要实际维护两个队列，所以只需要设计一个**对头元素总是与滑动窗口的最大值元素相对应**的辅助队列即可。首先向队列中添加元素创建滑动窗口，之后遍历数组并通过 1.出队列，2.入队列，3.返回窗口最大值 相关操作来维护该滑动窗口。

|    入队列    | 若当队列非空并且待加入元素大于队尾元素则将小于该待加入元素的队尾元素依次后退出队列再入队列，否则直接加入队列 |
| :----------: | :----------------------------------------------------------- |
|  **出队列**  | **如果队头元素等于滑动窗口的左边界则出队列**                 |
| **存最大值** | **直接保存当前队列的队头元素即可**                           |



## 代码

<!-- tabs:start -->

### **Java**

**解法一**

```java
class Solution {
public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        for (int i = k; i < nums.length; i++) {
            if (deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }
}
```

### **...**

```

```

<!-- tabs:end -->