class Solution {
    public boolean areOccurrencesEqual(String s) {
        
        Map<Character, Integer> map = new HashMap<>();

        for(Character ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        Integer value = map.get(s.charAt(0));

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(!entry.getValue().equals(value)) {
                return false;
            }
        }

        return true;
    }
}