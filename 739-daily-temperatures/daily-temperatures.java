class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        Stack<Map.Entry<Integer, Integer>> stack = new Stack<>();
        int[] answer = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.empty() && stack.peek().getKey() < temperatures[i]) {
                Map.Entry<Integer, Integer> entry = stack.pop();
                answer[entry.getValue()] = i - entry.getValue();
            }

            Map.Entry<Integer, Integer> map = Map.entry(temperatures[i], i);

            stack.push(map);
        }

        return answer;
    }
}

/*
73
*/