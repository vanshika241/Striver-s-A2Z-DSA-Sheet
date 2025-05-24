
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Easy {
    //Largest Element in an array 
    public static int largest(int[] arr) {
        // code here
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }

    //Second Largest Element in an Array without sorting
    public static int findSecondLargest(int n, int[] arr) {
		int max = arr[0];
		int smax = Integer.MIN_VALUE;
		for(int i=1;i<n;i++){
			if(arr[i]>max){
				smax = max;
				max = arr[i];
			}
			if(arr[i]<max && arr[i]>smax){
				smax = arr[i];
			}
		}

		if(smax == Integer.MIN_VALUE){
			return -1;
		}
		return smax;
	}

    //Check if array is sorted
    public boolean arraySortedOrNot(int[] arr) {
        if(arr.length==0 || arr.length==1){
            return true;
        }
        for(int i=1;i<arr.length;i++){
            if(arr[i-1] > arr[i]){
                return false;
            }
        }
        return true;
    }

    //Remove duplicates from Sorted array
    public int removeDuplicates(int[] arr) {
          int idx = 0;
        for(int i=1;i<arr.length;i++){
            if(arr[i] != arr[idx]){
                arr[idx+1] = arr[i];
                idx++;
            }
        }
        return idx+1;
    }

    
    //Left rotate an array by k places
    // for one place put k = 1
    public void reverse(int nums[], int i, int j){
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k %n;
        reverse(nums, 0,n-1);
        reverse(nums, 0,k-1);
        reverse(nums,k,n-1);
        
    }
    
    //Move Zeros to End
    public void moveZeroes(int[] arr) {
        int n = arr.length;
        int j = -1;
        for(int i=0;i<n;i++){
            if(arr[i] == 0){
                j = i;
                break;
            }
        }
        if(j == -1)return;
        for(int i=j+1;i<n;i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }

    //Linear Search
    static int search(int arr[], int x) {

        // Your code here
        for(int i=0;i<arr.length;i++){
            if(arr[i] == x){
                return i;
            }
        }
        return -1;
    }

    //Find the Union 
    public static List< Integer > sortedArray(int []a, int []b) {
        
       ArrayList<Integer> ans = new ArrayList<>();
        int i=0; //a
        int j = 0; //b
        int n = a.length;
        int m = b.length;
        while(i<n && j<m){
            if(a[i]<b[j] ){
                if(ans.size() == 0 || ans.get(ans.size()-1) != a[i]){
                    ans.add(a[i]);
                    
                }
                i++;
            }
            else if(b[j]<a[i]){
               if(ans.size() == 0 || ans.get(ans.size()-1) != b[j]){
                    ans.add(b[j]);
                    
                } 
                j++;
            }
            else{
                //equal
                   if(ans.size() == 0 || ans.get(ans.size()-1) != a[i]){
                    ans.add(a[i]);
                    
                   } 
                i++;
                j++;
            }
        }
        
        while(i<n){
            if(ans.size() == 0 || ans.get(ans.size()-1) != a[i]){
                    ans.add(a[i]);
                    
                }
                i++;
        }
        
        while(j<m){
            if(ans.size() == 0 ||  ans.get(ans.size()-1) != b[j]){
                    ans.add(b[j]);
                    
                } 
                j++;
        }
        
        return ans;
    }

    //Find the Missing Number 
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int tsum =( n*(n+1))/2;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += nums[i];
        }
        return tsum-sum;
    }

    //Maximum Consecutive Ones
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1){
                    count++;
                    maxCount = Math.max(count ,maxCount);
                    
            }
            else{
                count = 0;
            }
           
        }
        return maxCount;
    }

    //Find the number that appears once, and other numbers twice.
    int getSingle(int arr[]) {
        // code here
        int xor = 0;
        for(int num : arr){
            xor = xor ^ num;
        }
        return xor;
    }

    //Longest Array with given sum k
     public int longestSubarray(int[] arr, int k) {
        // code here
        HashMap<Integer,Integer> mp = new HashMap<>();
        int sum = 0;
        int maxlen = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            if(sum == k){
                maxlen = i+1;
            }
            else{
                int rem = sum-k;
                if(mp.containsKey(rem)){
                    maxlen = Math.max(maxlen , i-mp.get(rem));
                }
            }
            
            if(!mp.containsKey(sum)){
                mp.put(sum,i);
            }
        }
        return maxlen;
    }
    public static void main(String[] args) {
        
    }
}
