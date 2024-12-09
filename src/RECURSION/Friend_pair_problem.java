package RECURSION;

public class Friend_pair_problem {
    public static void main(String[] args) {
        System.out.println(Friend_Pair(3 ));
    }
    public static int Friend_Pair(int n){
        if(n==1 || n==2){
            return n;
        }
//        //choice
//        //single
//        int fnm1 =Friend_Pair(n-1);
//
//        //pair
//        int fnm2 =Friend_Pair(n-2);
//        int pairWays =(n-1) *fnm2;
//
//        //total ways
//        int total_way =fnm1+pairWays;
//        return total_way;
  return Friend_Pair(n-1) +(n-1)*Friend_Pair(n-2);
    }
}
