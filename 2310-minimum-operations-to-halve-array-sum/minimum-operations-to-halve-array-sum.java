class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> heap = new PriorityQueue<>(Comparator.reverseOrder());

        double sum = 0;
        int operations = 0;

        for(int num : nums) {
            sum += num;
            heap.add((double) num);
        }

        double currSum = sum;

        while(currSum > sum / 2) {
            Double biggest = heap.remove();
            heap.add(biggest / 2);
            currSum -= biggest / 2;
            operations++;
        }

        return operations;
    }
}