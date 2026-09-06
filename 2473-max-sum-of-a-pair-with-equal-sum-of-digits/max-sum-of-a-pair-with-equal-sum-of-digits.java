class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, TreeSet<Integer>> map = new HashMap<>();

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            int number = nums[i];
            int sumOfDigits = 0;
            while(number != 0) {
                sumOfDigits += number % 10;
                number = number / 10;
            }
            if(!map.containsKey(sumOfDigits)) {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(nums[i]);
                map.put(sumOfDigits, set);
            } else {
                TreeSet<Integer> set = map.get(sumOfDigits);
                max = Math.max(max, nums[i] + set.last());
                set.add(nums[i]);
            }
        }
        return max == Integer.MIN_VALUE ? -1 : max;
    }
}