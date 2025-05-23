
import java.util.Arrays;

public class QuickSort {

    public static int setPivot(int arr[], int low, int high){
        int pivot = arr[low];
        int i= low;
        int j = high;
        while (i<j) {
            while (i<=high-1 && arr[i]<=pivot ) {
                i++;
            }
            while (j>=low+1 && arr[j]>pivot ) {
                j--;
            }
            if(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j;
    }
    public static void quickSort(int arr[], int low, int high){
        if (low<high) {
         int partitionIdx = setPivot(arr, low, high);
        quickSort(arr, low, partitionIdx-1);
        quickSort(arr, partitionIdx+1, high);
        }
        
    }
    public static void main(String[] args) {
         int arr[] = {5,4,3,2,1};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
