class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] answer = new int[nums.length - k + 1];

        for(int i = 0; i < nums.length; i++) {
            
            while(!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }

            deque.addLast(i);
            
            if (deque.getFirst() + k == i) {
                deque.removeFirst();
            }

            if (i >= k - 1) {
                answer[i - k + 1] = nums[deque.getFirst()];
            }
        }

        return answer;
    }
}