class Solution {
    public int missingNumber(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i <= nums.length; i++) {
            map.put(i, 0);
        }

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], 1);
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 0) {
                return entry.getKey();
            }
        }

        return 0;
    }
}