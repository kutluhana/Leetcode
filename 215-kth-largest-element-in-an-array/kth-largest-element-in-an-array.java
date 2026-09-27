class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int num : nums) {
            heap.add(num);
        }

        while(heap.size() > k) {
            heap.remove();
        }

        return heap.remove();
    }
}