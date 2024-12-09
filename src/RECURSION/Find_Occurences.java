package RECURSION;

public class Find_Occurences {

    public static void main(String[] args) {
        int arr[] ={3,2,4,5,6,2,7,2,2};
        find_occur(arr,2,0);
    }
    public  static void find_occur(int arr[],int key,int i){
        if(i==arr.length){
            return;
        }
        if(arr[i]==key){
            System.out.print(i+" ");
        }
        find_occur(arr,2,i+1);
    }
}
