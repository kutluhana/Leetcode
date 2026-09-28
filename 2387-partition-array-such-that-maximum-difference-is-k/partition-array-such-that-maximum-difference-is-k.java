class Solution {
    public int partitionArray(int[] nums, int k) {

        Arrays.sort(nums);

        int min = nums[0];
        int max = nums[0];

        int subsequence = 1;

        for(int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);

            if(max - min > k) {
                subsequence++;
                min = nums[i];
                max = nums[i];
            }
        }

        return subsequence;
    }
}