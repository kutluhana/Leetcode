class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int stick : sticks) {
            heap.add(stick);
        }

        int currCost = 0;

        while(heap.size() > 1) {
            int smallest = heap.remove();
            int secondSmallest = heap.remove();

            currCost += smallest + secondSmallest;
            heap.add(smallest + secondSmallest);
        }
        
        return currCost;
    }
}