package SortingTecq;

import java.util.Arrays;

public class BasicsBSI{
    //Bubble Sort
    public static void bubbleSort(int arr[]){
        int n = arr.length;
        boolean check = false;
        for(int i=0;i<n-1;i++){
            for(int j=1;j<=n-1-i;j++){
                if (arr[j]<arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    check = true;
                }
            }
            if (check == false) {
                return;
            }
        }
    }

    //Selection Sort

    public static int getMax(int arr[], int start, int last){
        int maxIdx = 0;
        for(int i=start;i<=last;i++){
            if (arr[i]>arr[maxIdx]) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }
    public static void selectionSort(int arr[]){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            int lastIdx = n-1-i;
            int maxIdx = getMax(arr,0,lastIdx);
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[lastIdx];
            arr[lastIdx] = temp;
        }
    }

    //Insertion Sort 
    public static void insertionSort(int arr[]){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j>0;j--){
                if (arr[j]<arr[j-1]) {
                 int temp = arr[j];
                 arr[j] = arr[j-1];
                 arr[j-1] = temp;
                }
                else{
                    break;
                }
            }
             
        }
    }
    
    public static void main(String[] args) {
        int arr[] = {5,4,3,2,1};
        System.out.println(Arrays.toString(arr));
        //bubbleSort(arr);
        //selectionSort(arr);
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
