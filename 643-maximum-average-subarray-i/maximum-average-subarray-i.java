class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double currSum = 0;
        double max = 0;
        int left = 0;
        int right = 0;

        while(right - left + 1 <= k) {
            currSum += nums[right];
            right++;
        }

        max = currSum / k;

        for(; right < nums.length; right++) {
            currSum -= nums[left];
            left++;
            currSum += nums[right];

            max = Math.max(max, currSum / k);
        }

        return max;


    }
}