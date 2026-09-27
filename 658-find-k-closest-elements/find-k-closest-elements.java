class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> {
            if (Math.abs(n1 - x) == Math.abs(n2 - x)) {
                return n2 - n1;
            }
            
            return Math.abs(n2 - x) - Math.abs(n1 - x);
        });

        for(int element : arr) {
            heap.add(element);
        }

        while(heap.size() > k) {
            heap.remove();
        }

        List<Integer> list = new ArrayList<>();

        while(!heap.isEmpty()) {
            list.add(heap.remove());
        }

        Collections.sort(list);

        return list;
        
    }
}