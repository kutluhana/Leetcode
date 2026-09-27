class MedianFinder {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        minHeap.add(num);
        maxHeap.add(minHeap.remove());
        if(maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.remove());
        }
    }
    
    public double findMedian() {
        if(minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        }
        return (double) (minHeap.peek() + maxHeap.peek()) / 2;
    }
}
/*
100 200 300

10 20 30 15
*/

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */