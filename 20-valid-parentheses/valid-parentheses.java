class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');

        for(Character ch : s.toCharArray()) {
            if(map.containsKey(ch)) {
                stack.add(ch);
            } else {
                if(stack.empty()) {
                    return false;
                }

                Character previous = stack.pop();
                if(!map.get(previous).equals(ch)) {
                    return false;
                }
            }
        }

        return stack.empty();
    }
}