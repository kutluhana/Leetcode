class Solution {
    public int minStoneSum(int[] piles, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        int sum = 0;

        for(int pile : piles) {
            heap.add(pile);
            sum += pile;
        }

        for(int i = 0; i < k; i++) {
            Integer pile = heap.remove();
            heap.add(pile - pile / 2);
            sum -= pile / 2;
        }

        return sum;
        
    }
}