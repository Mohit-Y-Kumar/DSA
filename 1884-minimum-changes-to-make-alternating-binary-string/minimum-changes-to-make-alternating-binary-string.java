class Solution {
    public int minOperations(String s) {
        int n =s.length();
        int count1 =0;
        int count2 =0;
        for(int i = 0;i<n;i++){
           // pattern 0101...
            if (i % 2 == 0 && s.charAt(i) != '0') count1++;
            if (i % 2 == 1 && s.charAt(i) != '1') count1++;

            // pattern 1010...
            if (i % 2 == 0 && s.charAt(i) != '1') count2++;
            if (i % 2 == 1 && s.charAt(i) != '0') count2++;
                }
                return Math.min(count1,count2);
            }
        }
    

