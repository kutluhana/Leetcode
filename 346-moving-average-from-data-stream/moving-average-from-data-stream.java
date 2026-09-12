class MovingAverage {

    Queue<Integer> queue = new LinkedList<>();
    int size;

    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {

        queue.offer(val);
        
        while(queue.size() > size) {
            queue.poll();
        }

        int sum = 0;

        for(Integer value : queue) {
            sum += value;
        }

        return (double) sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */