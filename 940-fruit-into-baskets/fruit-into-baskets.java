class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> hm =new HashMap<>();
        int l =0;
        
        int n =fruits.length;
        int maxcount =0;
        for(int r = 0; r < fruits.length; r++){
            hm.put(fruits[r],hm.getOrDefault(fruits[r],0)+1);
           while(hm.size() > 2){
                hm.put(fruits[l], hm.get(fruits[l]) - 1);

                if(hm.get(fruits[l]) == 0){
                    hm.remove(fruits[l]);
                }
                l++;
            }
            maxcount =Math.max(maxcount,r-l+1);
            
            
        }
        return maxcount;
        
    }
}