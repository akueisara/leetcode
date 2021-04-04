class MyCircularQueue {
    private Queue<Integer> queue;
    private int limit;
    private int lastAddedElement;

    public MyCircularQueue(int k) {
        queue = new LinkedList<>();
        limit = k;
    }
    
    public boolean enQueue(int value) {
        if (queue.size() < limit) {
            queue.add(value);
            lastAddedElement = value;
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
        if (queue.size() > 0) {
            queue.poll();
            return true;
        }
        return false;
    }
    
    public int Front() {
        if(queue.size() == 0) {
            return -1;
        }
        return queue.peek();
    }
    
    public int Rear() {
        if(queue.size() == 0) {
            return -1;
        }
        return lastAddedElement;
    }
    
    public boolean isEmpty() {
        return queue.size() == 0;
    }
    
    public boolean isFull() {
        return queue.size() == limit;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */