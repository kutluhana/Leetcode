class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        int[] prefix = new int[nums.length];

        prefix[0] = nums[0] % 2;

        for(int i = 1; i < prefix.length; i++) {
            prefix[i] += prefix[i - 1] + nums[i] % 2;
        }

        int subarrays = 0;
        Map<Integer, Integer> countMap = new HashMap<>();

        countMap.put(0, 1);

        for (int p : prefix) {
            if (countMap.containsKey(p - k)) {
                subarrays += countMap.get(p - k);
            }
            countMap.put(p, countMap.getOrDefault(p, 0) + 1);
        }

        return subarrays;
    }
}













/*class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, 1);
        
        int ans = 0;
        int curr = 0;
        
        for (int num: nums) {
            curr += num % 2;
            ans += counts.getOrDefault(curr - k, 0);
            counts.put(curr, counts.getOrDefault(curr, 0) + 1);
        }
        
        return ans;
    }
}*/