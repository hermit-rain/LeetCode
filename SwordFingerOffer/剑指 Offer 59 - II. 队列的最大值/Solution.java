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

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */