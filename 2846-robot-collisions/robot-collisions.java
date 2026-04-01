class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n =positions.length;
        Integer [] order =new Integer[n];
        for(int i =0;i<n;i++){
            order[i] =i;
        }
        Arrays.sort(order,(a,b) ->positions[a] -positions[b]);
        
        boolean destroyed[] =new boolean[n];
        Deque<Integer>st =new ArrayDeque<>();

        for(int i :order){
            if(directions.charAt(i) =='R'){
                st.push(i);
            }else{
                while(!st.isEmpty() && directions.charAt(st.peek()) =='R'){
                    int top =st.peek();
                    if(healths[top]>healths[i]){
                        healths[top]--; destroyed[i] =true;break;
                    } else if(healths[top] <healths[i]){
                        healths[i]--;destroyed[top] =true;st.pop();
                    }else{
                        destroyed[i] =destroyed[top] =true; st.pop();                  break;
                    }
                }
                if(!destroyed[i]) st.push(i);
            }
        }

        List<Integer> res =new ArrayList<>();
        for(int i =0;i<n;i++){
            if(!destroyed[i])  res.add(healths[i]);
        }
        return res;

        
    }
}