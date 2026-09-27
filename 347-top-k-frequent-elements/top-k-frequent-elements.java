class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((number1, number2) -> map.get(number1) - map.get(number2));

        for(int num : nums) {
            Integer currFreq = map.getOrDefault(num, 0);
            map.put(num, currFreq + 1);
        }

        for(Integer key : map.keySet()) {
            heap.add(key);
        }

        while(heap.size() > k) {
            heap.remove();
        }

        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = heap.remove();
        }
        
        return answer;
    }
}