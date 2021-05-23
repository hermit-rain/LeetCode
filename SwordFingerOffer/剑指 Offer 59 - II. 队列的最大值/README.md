# [剑指 Offer 59 - II. 队列的最大值](https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/)

## 题目描述

请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。

若队列为空，pop_front 和 max_value 需要返回 -1

**示例 1：**

```
输入: 
["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
[[],[1],[2],[],[],[]]
输出: [null,null,null,2,1,2]
```

**示例 2：**

```
输入: 
["MaxQueue","pop_front","max_value"]
[[],[],[]]
输出: [null,-1,-1]
```

**限制：**

```
1 <= push_back,pop_front,max_value的总操作数 <= 10000
1 <= value <= 10^5
```

## 解题思路

- 解法一：定义辅助双端队列，对于一个普通的队列，push_back 和 pop_front 的时间复杂度都是 O(1)，因此我们直接使用队列的相关操作就可以实现这两个方法。本题的关键在于实现一个时间复杂度为O(1) 的max_value 方法，我们通常的想法是每次入队列的时候都会更新其最大值，但是一旦有元素出队列，我们就没办法通过O(1) 重新找到最大值。因此我们通过定义一个双端队列作为辅助队列，**队头永远保证与主队列中的最大值元素相对应**即可。

  |     方法设计     |    主队列     |                         辅助双端队列                         |
  | :--------------: | :-----------: | :----------------------------------------------------------: |
  | push_back(value) | 将value入队列 | 1.如果队列为空则直接入队列。2.否则判断队尾元素是否小于即将入队列的元素，若小于则将小于value的元素全部出队列后，再将value入队，否则直接入队列。 |
  |    pop_front     | 将value出队列 | 如果主队列出队列的队头元素和辅队列的队头元素相同则也将辅队列的队头元素出队列 |
  |    max_value     |     null      |                直接返回辅助队列的队头元素即可                |

  

  

  

## 代码

<!-- tabs:start -->

### **Java**

**解法一**

```java
class MaxQueue {
    LinkedList<Integer> list1;
    LinkedList<Integer> list2;

    public MaxQueue() {
        list1 = new LinkedList<>();
        list2 = new LinkedList<>();
    }

    public int max_value() {
        if (list2.isEmpty()) {
            return -1;
        }
        return list2.peekFirst();
    }

    public void push_back(int value) {
        list1.offer(value);
        while (!list2.isEmpty() && list2.peekLast() < value) {
            list2.pollLast();
        }
        list2.offer(value);
    }

    public int pop_front() {
        if (list1.isEmpty()) {
            return -1;
        }
        if (list1.peekFirst().equals(list2.peekFirst())) {
            list2.pollFirst();
        }
        return list1.pollFirst();
    }
}
```


### **...**

```

```

<!-- tabs:end -->