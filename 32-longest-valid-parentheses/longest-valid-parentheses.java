class Solution {
    public int longestValidParentheses(String s) {
        ///remove all valid parenthesis
        Stack<Integer>st =new Stack<>();

        removevalidParenthesis(s,st);
        //if stack is empty then there were no invalid parenthesis so return len;

        if(st.isEmpty()){
            return s.length();
        }

        ArrayList<Integer> ar =new ArrayList<>();
        formArrayOfInvalidIdx(ar,st,s);

        //find the diff b/w to invalid idx

        int max =0;
        for(int i =1;i<ar.size();i++){
            int prev =ar.get(i-1);
            max =Math.max(max,ar.get(i)-prev-1);
        }
        return max;
        
    }
  void removevalidParenthesis(String s,Stack<Integer> st){
    for(int i =0;i<s.length();i++){
        char ch =s.charAt(i);
        if(ch =='('){
            st.push(i);
        }else{
            if(st.isEmpty() || s.charAt(st.peek())==')'){
                st.push(i);
            }else{
                st.pop();
            }
        }
    }
  }

    void   formArrayOfInvalidIdx(ArrayList<Integer> ar,Stack<Integer>st,String s){
        ar.add(0,s.length());

        while(!st.isEmpty()){
            ar.add(0,st.pop());
        }
        ar.add(0,-1);
    }
  

}