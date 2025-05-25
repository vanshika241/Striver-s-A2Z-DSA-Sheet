
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Medium {
    //Two Sum Problem 
      public int[] twoSum(int[] nums, int target) {
      HashMap<Integer,Integer> mp = new HashMap<>();
      for(int i=0;i<nums.length;i++){
        int rem = target-nums[i];
        if(mp.containsKey(rem)){
            return new int[]{mp.get(rem),i};
        }
        if(!mp.containsKey(nums[i])){
            mp.put(nums[i],i);
        }
      }
      return new int[]{-1,-1};
    }

    //Sort012 
    public void sortColors(int[] arr) {
      int  n = arr.length;
      int low = 0;
      int mid = 0;
      int high = n-1;
      while(mid<=high){
        if(arr[mid] == 0){
            int temp = arr[low];
            arr[low] = arr[mid];
            arr[mid] = temp;
            mid++;
            low++;
        }
        else if(arr[mid] == 2){
            int temp = arr[high];
            arr[high] = arr[mid];
            arr[mid] = temp;
            high--;
        }
        else{
            mid++;
        }
      }
      
    }

    //Majority Element 
    public int majorityElement(int[] nums) {
      int n = nums.length;
      int cnt =0;
      int el = Integer.MIN_VALUE;
      for(int i=0;i<n;i++){
          if(cnt == 0){
             el =  nums[i];
             cnt = 1;
          }
          else if(nums[i] == el){
              cnt++;
          }
          else{
              cnt--;
          }
      }

      cnt = 0;
      for(int i=0;i<n;i++){
          if(nums[i] == el){
              cnt++;
          }
      }
      if(cnt>n/2)return el;
      return -1;
  }

  //Kadane's Algorithm, maximum subarray sum 
  public int maxSubArray(int[] arr) {
    int max = Integer.MIN_VALUE;
     int currSum = 0;
     for(int i=0;i<arr.length;i++){
         currSum += arr[i];
         if (currSum>max) {
             max = currSum;
         }
         if (currSum <0) {
             currSum = 0;
         }
     }
     return max;
 }

 //Stock Buy and Sell
  public int maxProfit(int[] prices) {
  int min = prices[0];
  int maxProfit = 0;
  for(int i=1;i<prices.length;i++){
    int cost = prices[i]-min;
    maxProfit = Math.max(maxProfit , cost);
    min = Math.min(min,prices[i]);
  }
  return maxProfit;
}

  //Rearrange the array in alternating positive and negative items
  public int[] rearrangeArray(int[] nums) {
    int arr[] = new int[nums.length];
    int pos = 0;
    int neg = 1;
    for(int i=0;i<nums.length;i++){
        if(nums[i]>=0){
            arr[pos] = nums[i];
            pos+=2;
        }
        else{
            arr[neg] = nums[i];
            neg += 2;
        }
    }
    return arr;
}

  //Leaders in an Array problem
  static ArrayList<Integer> leaders(int arr[]) {
        // code here
        ArrayList<Integer>  ans = new ArrayList<>();
        int n = arr.length;
        int currMax = arr[n-1];
        ans.add(currMax);
        for(int i=n-2;i>=0;i--){
            if(arr[i]>=currMax){
                ans.add(arr[i]);
                currMax = arr[i];
            }
        }
        Collections.sort(ans, Collections.reverseOrder());
        return ans;
    }

    //Longest Consecutive Sequence in an Array
    public int longestConsecutive(int[] nums) {
        int maxlen = 0;
        HashSet<Integer> s = new HashSet<>();
        for(int num : nums){
            s.add(num);
        }
        for(int num:s){
            if(!s.contains(num-1)){
                int currlen = 1;
                int currNum = num;
                while(s.contains(currNum+1)){
                    currlen++;
                    currNum++;
                }
                maxlen = Math.max(maxlen,currlen);
            }
        }
        return maxlen;
    }

    //Next Permutation
    public static void reverse(int nums[], int i, int j){
        while(i<j){
            int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            i++;
            j--;
        }
    }
    public void nextPermutation(int[] nums) {
        int pivot = -1;
        int n = nums.length;
        for(int i =n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                pivot = i;
                break;
            }
        }
        if(pivot == -1){ // nums = [3,2,1]
            reverse(nums,0,n-1);
            return;
        }
         for(int i =n-1;i>=pivot;i--){
            if(nums[i]>nums[pivot]){
                int temp = nums[i];
                nums[i] = nums[pivot];
                nums[pivot] = temp;
                break;
            }
        }

        reverse(nums,pivot+1,n-1);
    }
     
    //Set Matrix Zeros
        public void setZeroes(int[][] matrix) {
            int col  = 1;
            int m = matrix.length;
            int n = matrix[0].length;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(matrix[i][j] == 0){
                        if(j != 0){
                            matrix[0][j] = 0;
                        }
                        else{
                            col = 0;
                        }
                        matrix[i][0] = 0;
                    }
                }
            }
    
            for(int i=1;i<m;i++){
                for(int j = 1;j<n;j++){
                    if(matrix[i][0] == 0 || matrix[0][j] == 0){
                        matrix[i][j] = 0;
                    }
                }
            }
            if(matrix[0][0] == 0){
                for(int j=0;j<n;j++){
                    matrix[0][j] = 0;
                }
            }
            if(col == 0){
                for(int i=0;i<m;i++){
                    matrix[i][0] = 0;
                }
            }
    
    
        }

    //Rotate Matrix by 90
    public void reverseRow(int arr[]){
        int i = 0;
        int j = arr.length-1;
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
               int temp = matrix[i][j];
               matrix[i][j] = matrix[j][i];
               matrix[j][i] = temp;
            }
        }

        for(int i=0;i<n;i++){
            reverseRow(matrix[i]);
        }
    }

    //Print the Matrix in Spiral Form
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int startRow = 0;
        int startCol = 0;
        int endRow = m-1;
        int endCol = n-1;
        while(startRow <= endRow && startCol <= endCol){
            for(int j=startCol;j<=endCol;j++){
                ans.add(matrix[startRow][j]);
            }
            
            for(int i=startRow+1;i<=endRow;i++){
                ans.add(matrix[i][endCol]);
            }

            if(startRow<endRow){
                for(int j=endCol-1;j>=startCol;j--){
                ans.add(matrix[endRow][j]);
            }
            }

             if(startCol<endCol){
                for(int i=endRow-1;i>startRow;i--){
                ans.add(matrix[i][startCol]);
               }

            }
             

            startRow++;
            startCol++;
            endRow--;
            endCol--;
            

        }

        return ans;
        
    }

    //Count subarrays with given sum
    public int subarraySum(int[] a, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        int cnt = 0;
        int sum = 0;
        for(int num : a){
         sum += num;
         int rem = sum-k;
         if(mp.containsKey(rem)){
             cnt += mp.get(rem);
         }
 
 
         if(!mp.containsKey(sum)){
             mp.put(sum,1);
         }
         else{
             mp.put(sum, mp.get(sum)+1);
         }
        }
        return cnt;
     }

    

    public static void main(String[] args) {
        
    }
}
