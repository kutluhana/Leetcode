class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0; i < stones.length; i++) {
            heap.add(stones[i]);
        }


        while(heap.size() > 1) {
            int biggest = heap.remove();
            int secondBiggest = heap.remove();

            if(biggest - secondBiggest > 0) {
                heap.add(biggest - secondBiggest);
            }
        }

        return heap.size() == 0 ? 0 : heap.remove();
    }
}