class Solution {
    public char repeatedCharacter(String s) {
        
        Map<Character, Character> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) != null) {
                return s.charAt(i);
            } else {
                map.put(s.charAt(i), s.charAt(i));
            }
        }

        return '0';
    }
}