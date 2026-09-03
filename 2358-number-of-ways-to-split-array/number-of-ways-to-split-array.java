class Solution {
    public int waysToSplitArray(int[] nums) {
        
        long[] prefix = new long[nums.length];
        int count = 0;
        prefix[0] = nums[0];

        for(int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        for(int i = 0; i < prefix.length - 1; i++) {
            if(prefix[i] >= prefix[prefix.length - 1] - prefix[i]) {
                count++;
            }
        }
        return count;
    }
}
// 5 elemanlı, i = 0, 1  2 3 4 5