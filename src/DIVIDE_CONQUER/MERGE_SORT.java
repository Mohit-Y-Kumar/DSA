package DIVIDE_CONQUER;


public class MERGE_SORT {
    public static void PrintArr(int arr[]){
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i] +" ");
        }
    }

    public static void mergeSort(int arr[], int si,int ei){
        if(si>=ei){
            return;
        }

        //kaam

        int mid =si+(ei-si)/2;
        //left
        mergeSort(arr,si,mid);
        //right
        mergeSort(arr,mid+1,ei);

        merge(arr,si,mid,ei);
    }

    public static void merge(int arr[], int si,int mid,int ei){
     //left(0,3) =4 right(4,6) =3 -->6-0+1
        int temp[] =new int[ei-si+1];
        int i =si; //iterator for left part
        int j =mid+1; //iterator for right part
        int k =0; //iterator for temp arr

        while (i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k] =arr[i];
                i++;
            } else{
                temp[k] =arr[j];
                j++;
            }
            k++;
        }
        //left part
        //bache hue element both
        while (i<=mid){
            temp[k++] =arr[i++];
        }
        //right part
        while (j <= ei){
            temp[k++]= arr[j++];
        }

        //copy temp to original array
        for(k=0,i=si;k< temp.length; k++,i++){
            arr[i] =temp[k];
        }
    }

    public static void main(String[] args) {
        int arr[] ={6,3,9,5,2,8,-6};
        mergeSort(arr,0,arr.length-1);
        PrintArr(arr);
    }

}
