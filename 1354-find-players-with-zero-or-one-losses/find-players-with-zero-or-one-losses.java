class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> lossesCount = new TreeMap<>();

        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];

            lossesCount.putIfAbsent(winner, 0);

            lossesCount.put(loser, lossesCount.getOrDefault(loser, 0) + 1);
        }

        List<Integer> zeroLosses = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : lossesCount.entrySet()) {
            int count = entry.getValue();
            if (count == 0) {
                zeroLosses.add(entry.getKey());
            } else if (count == 1) {
                oneLoss.add(entry.getKey());
            }
        }

        return List.of(zeroLosses, oneLoss);
    }
}