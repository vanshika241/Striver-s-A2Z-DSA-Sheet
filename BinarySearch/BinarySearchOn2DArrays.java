public class BSOn2DArrays {
    //Search in a 2 D matrix
    public  boolean binarySearch(int[] arr, int target){
        int n = arr.length;
        int start  =0;
        int end = n-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid] == target){
                return true;
            }
            else if(arr[mid]>target){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
      for(int i=0;i<matrix.length;i++){
        if(binarySearch(matrix[i] , target) == true){
            return true;
        }
      }

      return false;
    }
    public static void main(String[] args) {
        
    }
}
