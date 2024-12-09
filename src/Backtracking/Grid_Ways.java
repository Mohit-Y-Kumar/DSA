package Backtracking;

public class Grid_Ways {
    public static int Grid_ways(int i,int j,int n,int m){
        //base case
        if(i==n-1 || j==m-1) {// condn for last cell
            return 1;
        }
        else if(i==n || j==n){ //boundry condition
            return 0;
        }
        int w1 =Grid_ways(i+1,j,m,n);
        int w2 =Grid_ways(i,j+1,m,n);
            return w1+w2;
    }

    public static void main(String[] args) {
        int n=3,m=3;
        System.out.println(Grid_ways(0,0,n,m));
    }
}
