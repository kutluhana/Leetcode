class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int left = 0;
        int right = 0;
        int max = 0;
        int currFlip = 0;

        for(; right < nums.length; right++) {
            if(nums[right] == 0) {
                currFlip++;
            }

            if(currFlip > k) {
                while(nums[left] != 0) {
                    left++;
                }
                currFlip--;
                left++;
            }

            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}