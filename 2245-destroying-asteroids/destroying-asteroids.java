class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int asteroid : asteroids) {
            heap.add(asteroid);
        }

        long currMass = mass;

        while(!heap.isEmpty()) {
            int smallest = heap.remove();

            if(smallest > currMass) {
                return false;
            }

            currMass += smallest;
        }

        return true;
    }
}