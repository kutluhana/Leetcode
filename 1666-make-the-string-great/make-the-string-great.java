class Solution {
    public String makeGood(String s) {
        
        Stack<Character> stack = new Stack<>();

        for(Character ch : s.toCharArray()) {

            if((!stack.empty() && (Character.toUpperCase(stack.peek()) == ch || Character.toLowerCase(stack.peek()) == ch)) && 
            (Character.isUpperCase(stack.peek()) && Character.isLowerCase(ch)|| 
            !stack.empty() && Character.isLowerCase(stack.peek())&& Character.isUpperCase(ch))){
                stack.pop();
            } else {
                stack.add(ch);
            }
        }

        StringBuilder builder = new StringBuilder();

        for(Character ch : stack) {
            builder.append(ch);
        }

        return builder.toString();
    }
}