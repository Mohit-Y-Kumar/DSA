class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> has =new HashMap<>();
        for(int num :arr){
            has.put(num, has.getOrDefault(num, 0) + 1);

        }
        Set<Integer> s = new HashSet<>();
        for (int x : has.values()) {
            s.add(x);
        }

        return has.size() == s.size();
    }
}