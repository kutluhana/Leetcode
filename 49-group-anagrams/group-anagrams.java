class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> list = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        
        for(String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);

            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }

            map.get(key).add(str);
        }

        return new ArrayList(map.values());
    }
}