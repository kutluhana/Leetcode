class Solution {
    public String removeDuplicates(String s) {

        Stack<Character> stack = new Stack<>();

        for(Character ch : s.toCharArray()) {

            if(!stack.empty() && ch.equals(stack.peek())) {
                stack.pop();
            } else {
                stack.add(ch);
            }
        }

        StringBuilder answerBuilder = new StringBuilder();
        while(!stack.empty()) {
            answerBuilder.append(stack.pop());
        }

        return new String(answerBuilder.reverse());

    }
}