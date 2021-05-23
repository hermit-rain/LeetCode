class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //初始判定
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        //定义一个双端队列 ==> 对头维护滑动窗口的最大值
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        //创建滑动窗口
        for (int i = 0; i < k; i++) {
            //如果当前队列非空并且待加入的元素大于队尾元素则 先将小于待加入元素的队尾元素依次后退出队列,再将其入队列。否则直接入队列
            //保证队头元素总是滑动窗口的最大值
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        //滑动窗口建成后 模拟向右滑动 通过 1.出队列 2.入队列 3.存最大值 相应操作 维护该滑动窗口
        for (int i = k; i < nums.length; i++) {
            //1.出队列 => 如果当前队列的队头元素与滑动窗口的头元素相同则出队列
            if (deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            //2.入队列 => 如果当前队列非空并且待加入的元素大于队尾元素则 先将小于待加入元素的队尾元素依次后退出队列,再将其入队列
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            //3.将当前滑动窗口的最大值存入返回数组
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }

}