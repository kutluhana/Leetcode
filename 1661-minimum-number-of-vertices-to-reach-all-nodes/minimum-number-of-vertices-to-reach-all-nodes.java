class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        int[] answer = new int[n];

        for(int i = 0; i < edges.size(); i++) {
            answer[edges.get(i).get(1)] = 1;
        }

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < answer.length; i++) {
            if(answer[i] == 0) {
                list.add(i);
            }
        }

        return list;
    }
}