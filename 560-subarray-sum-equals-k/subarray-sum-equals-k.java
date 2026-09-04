class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int[] prefix = new int[nums.length];

        prefix[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int left = 0;
        int right = 1;
        int count = 0;

        if(prefix[0] == k) {
            count++;
        }

        for(; right < prefix.length; right++) {
            left = 0;
            while(left <= right) {
                if(prefix[right] - prefix[left] + nums[left] == k) {
                    count++;
                }
                left++;
            }
        }

        return count;
    }
}