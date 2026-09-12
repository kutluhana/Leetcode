class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        StringBuilder sBuilder = new StringBuilder();


        Stack<Character> sStack = new Stack<>();

        for(Character ch : s.toCharArray()) {
            if(!sStack.empty() && ch.equals('#')) {
                sStack.pop();
            } else if(!ch.equals('#')){
                sStack.add(ch);
            }
        }

        StringBuilder tBuilder = new StringBuilder();
        Stack<Character> tStack = new Stack<>();

        for(Character ch : t.toCharArray()) {
            if(!tStack.empty() && ch.equals('#')) {
                tStack.pop();
            } else if(!ch.equals('#')){
                tStack.add(ch);
            }
        }

        while(!sStack.empty()) {
            sBuilder.append(sStack.pop());
        }
        while(!tStack.empty()) {
            tBuilder.append(tStack.pop());
        }

        return tBuilder.toString().equals(sBuilder.toString());

    }
}