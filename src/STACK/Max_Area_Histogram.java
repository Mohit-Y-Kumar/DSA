package STACK;

import java.util.Stack;

public class Max_Area_Histogram {
    public static  void  maxArea(int arr[]){  ///O(n) linear -->optimize
        int maxArea =0;
        int nsl[] =new int[arr.length];
        int nsr[] =new int [arr.length];

        //Next  Smaller Right
        Stack<Integer> s =new Stack<>();

        for (int i = arr.length-1; i >=0 ; i--) {
          while (!s.isEmpty() && arr[s.peek()] >=arr[i]){
              s.pop();
          }
          if(s.isEmpty()){
              nsr[i] =arr.length;
          }
          else{
              nsr[i] =s.peek();
          }
          s.push(i);
        }


        //Next Smaller Left

        s =new Stack<>();
        for (int i = 0; i <arr.length ; i++) {
            while (!s.isEmpty() && arr[s.peek()] >=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i] =-1;
            }
            else{
                nsl[i] =s.peek();
            }
            s.push(i);
        }

        // Current ARea :widht =j-i-1; =nsr[j] -nsl[i] -1;
        for (int i = 0; i <arr.length ; i++) {
            int height =arr[i];
            int widht =nsr[i] -nsl[i] -1;
            int currArea =height*widht;

            maxArea =Math.max(currArea,maxArea);


        }

        System.out.println("max area of histogram is "+ maxArea);

    }

    public static void main(String[] args) {
        int arr [] ={2,4}; //hight of histogram
        maxArea(arr);
    }
}
