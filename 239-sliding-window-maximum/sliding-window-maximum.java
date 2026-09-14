class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] answer = new int[nums.length - k + 1];

        for(int i = 0; i < nums.length; i++) {
            
            while(!queue.isEmpty() && nums[queue.getLast()] < nums[i]) {
                queue.removeLast();
            }
            queue.offerLast(i);

            if(queue.getFirst() + k == i) {
                queue.removeFirst();
            }

            if (i >= k - 1) {
                answer[i - k + 1] = nums[queue.getFirst()];
            }
        }
        return answer;
    }
}