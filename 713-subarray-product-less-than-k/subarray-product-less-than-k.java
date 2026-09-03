class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        int left = 0;
        int currProduct = 1;
        int count = 0;

        for(int right = 0; right < nums.length; right++) {
            currProduct *= nums[right];

            while(currProduct >= k && left <= right) {
                currProduct /= nums[left];
                left++;
            }
            count += right - left + 1;
        }

        return count;
    }
}

// 1 5 3 6 4 2 5