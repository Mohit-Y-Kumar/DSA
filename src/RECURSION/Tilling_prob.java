package RECURSION;

public class Tilling_prob {
    public static void main(String[] args) {
        System.out.println(tilingProblem(3));
    }

    public static int tilingProblem(int n){
        if(n==0 || n==1){
            return 1;
        }
        //Kam
        //Vertical

        int fnm1 =tilingProblem(n-1);

        // Horizontol
        int fnm2 =tilingProblem(n-2);

        int totWays =fnm1+fnm2;
        return totWays;
    }
}
