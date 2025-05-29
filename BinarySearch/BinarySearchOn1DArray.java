
import java.util.ArrayList;

public class BSArrays1D {

    //Binary Search to find X in sorted array
    public static int binarySearch(int[] arr, int target){
        int n = arr.length;
        int start  =0;
        int end = n-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid]>target){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return -1;
    }

     //Implement lower bound
      public static int lowerBound(int []arr, int n, int target) {
        int ans = n;
        int start  =0;
        int end = n-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid] >=target){
                ans =mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;

    }

    //Implement Upper Bound
     public static int upperBound(int []arr, int target, int n){
         int ans = n;
        int start  =0;
        int end = n-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid] >target){
                ans =mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;
    }

    //Search Insert Position
    public int searchInsert(int[] arr, int target) {
        int n = arr.length;
        int start  =0;
        int end = n-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid]>target){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return start;
    }

    //Find Floor of an element in a sorted array
    static int findFloor(int[] arr, int target) {
        int n = arr.length;
        int start = 0;
        int end = n-1;
        int ans = -1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]<=target){
                ans = mid;
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return ans;
    }

    //Find Ceil of an element in a sorted array
    public int findCeil(int[] arr, int target) {
        // code here
        int n = arr.length;
        int start = 0;
        int end = n-1;
        int ans = -1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]>=target){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;
    }

    //Find First and Last Position of Element in Sorted Array
    public static int firstOcc(int[] arr, int target){
        int n = arr.length;
        int start  =0;
        int end = n-1;
        int ans = -1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid] == target){
                ans =  mid;
                end = mid-1;
            }
            else if(arr[mid]>target){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;
    }

    public static int lasttOcc(int[] arr, int target){
        int n = arr.length;
        int start  =0;
        int end = n-1;
        int ans = -1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid] == target){
                ans =  mid;
                start = mid+1;
            }
            else if(arr[mid]>target){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int ans1 = firstOcc(nums,target);
        int ans2 = lasttOcc(nums,target);
        if(ans1 == -1 || ans2 == -1){
            return new int[]{ans1,ans2};
        }
        return new int[]{ans1,ans2};
    }

    //Count occurrences of a number in a sorted array with duplicates
    static int countFreq(int[] arr, int target) {
        int ans1 = firstOcc(arr,target);
        int ans2 = lasttOcc(arr,target);
        if(ans1 == -1 || ans2 == -1)return 0;
        return ans2-ans1+1;
    }

    //Search in Rotated Sorted Array I
    public int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n-1;
        while(start <=end){
            int mid = start +(end-start)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[start]<=nums[mid]){ // left sorted check else move to right part
              if(nums[start] <=target && nums[mid]>=target){
                end = mid-1;
              }
              else{
                start = mid+1;
              }
            }
            else{
               if(nums[mid] <=target && nums[end]>=target){
                start = mid+1;
              }
              else{
                end = mid-1;
              }
            }
        }
     return -1;
    }
    
    //Search in Rotated Sorted Array II
    public boolean searchDuplicates(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n-1;
        while(start <=end){
            int mid = start +(end-start)/2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[mid] == nums[start] && nums[mid] == nums[end]){
                start++;
                end--;
                continue;
            }
            if(nums[start]<=nums[mid]){ // left sorted check else move to right part
              if(nums[start] <=target && nums[mid]>=target){
                end = mid-1;
              }
              else{
                start = mid+1;
              }
            }
            else{
               if(nums[mid] <=target && nums[end]>=target){
                start = mid+1;
              }
              else{
                end = mid-1;
              }
            }
        }
     return false;
    }

    //Find minimum in Rotated Sorted Array
    public int findMin(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n-1;
        int ans = Integer.MAX_VALUE;
        while(start <=end){
            int mid = start +(end-start)/2;
            if(nums[start]<=nums[end]){
                ans = Math.min(ans,nums[start]);
                break;
            }
            if(nums[start]<=nums[mid]){
                //left part sorted else right part sorted
                ans = Math.min(ans,nums[start]);
                start = mid+1;
            }
            else{
                ans = Math.min(ans,nums[mid]);
                end = mid-1;
            }
        }
        return ans;
    }

    //Find out how many times has an array been rotated
    public static int findKRotation(int []nums){
       int n = nums.length;
        int start = 0;
        int end = n-1;
        int ans = Integer.MAX_VALUE;
        int index = -1;
        while(start <=end){
            int mid = start +(end-start)/2;
            if(nums[start]<=nums[end]){
                if(nums[start]<ans){
                    index = start;
                    ans = nums[start];
                }
                
                break;
            }
            if(nums[start]<=nums[mid]){
                //left part sorted else right part sorted
                if(nums[start]<ans){
                    index = start;
                    ans = nums[start];
                }                
                start = mid+1;
            }
            else{
                if(nums[mid]<ans){
                    index = mid;
                    ans = nums[mid];
                }
                end = mid-1;
            }
        }
        return index;
    }

    //Single element in a Sorted Array
    int findOnce(int[] arr) {
        int n = arr.length;
        //boundary Checks
        if(n == 1)return arr[0];
        if(arr[0] != arr[1])return arr[0];
        if(arr[n-1] != arr[n-2])return arr[n-1];
        //Binary Search
        int start = 1;
        int end = n-2;
        while(start <=end){
            int mid = start +(end-start)/2;
            if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1]){
                return arr[mid];
            }
            else if((arr[mid] == arr[mid-1]) && (mid%2 != 0)){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
     }

     //Find Peak Element 
     public static int findPeakElement(ArrayList<Integer> arr) {
        int n = arr.size();
        if(n == 1)return 0;

        int start = 0;
        int end = n-1;
        while(start <=end){
            int mid = start +(end-start)/2;
            if(mid>0 && mid<n-1){
                if(arr.get(mid) >arr.get(mid-1) && arr.get(mid)>arr.get(mid+1)){
                    return mid;
                }
                else if(arr.get(mid) >arr.get(mid-1)){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
            else if(mid == 0){
                if(arr.get(0) >arr.get(1)){
                    return 0;
                }
                else{
                    return 1;
                }
            }
            else{
                if(arr.get(n-1) >arr.get(n-2)){
                    return n-1;
                }
                else{
                    return n-2;
                }
            }
        }

        return -1;
    }

    
    public static void main(String[] args) {
        
    }
}
