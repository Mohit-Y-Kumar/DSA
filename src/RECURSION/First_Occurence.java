package RECURSION;

public class First_Occurence {
    public static void main(String[] args) {
        int arr[] ={3,2,5,9,12,6};
        System.out.println(firstoccurence(arr,5,0));

    }

    public static int firstoccurence(int arr[],int key,int i){
        if(i==arr.length){
            return -1;
        }
        if(arr[i] ==key){
            return i;
        }
        return firstoccurence(arr,key,i+1);
    }
}
