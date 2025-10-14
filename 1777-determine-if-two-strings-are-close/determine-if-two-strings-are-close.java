class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() !=word2.length()){
            return false;
        }
       Map<Character, Integer> freq1 = new HashMap<>();
        Map<Character, Integer> freq2 = new HashMap<>();
        for(char ch:word1.toCharArray()){
            freq1.put(ch,freq1.getOrDefault(ch,0)+1);
        }
        for(char ch:word2.toCharArray()){
            freq2.put(ch,freq2.getOrDefault(ch,0)+1);
        }
        if (!freq1.keySet().equals(freq2.keySet())) {
            return false;
        }
        List<Integer> list1 = new ArrayList<>(freq1.values());
        List<Integer> list2 = new ArrayList<>(freq2.values());
        Collections.sort(list1);
        Collections.sort(list2);

        return list1.equals(list2);
    }
}