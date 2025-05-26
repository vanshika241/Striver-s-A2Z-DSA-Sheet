import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Hard {

    //Pascal's Triangle 
    public List<Integer> printRow(int rowNumber){
        List<Integer> temp = new ArrayList<>();
        int ans = 1;
        temp.add(ans);
        for(int i=1;i<rowNumber;i++){
            ans = ans*(rowNumber-i);
            ans = ans/i;
            temp.add(ans);
        }

        return temp;

    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            List<Integer> temp = printRow(i);
            ans.add(temp);
        }
        return ans;
    }

    //3Sum Problem 
      public List<List<Integer>> threeSum(int[] nums) {
        // HashSet<List<Integer>> st = new HashSet<>();
         int n =  nums.length;
        // for(int i=0;i<n;i++){
        //     HashSet<Integer> s = new HashSet<>();
        //     for(int j=i+1;j<n;j++){
        //         int third = -(nums[i]+nums[j]);
        //         if(s.contains(third)){
        //             List<Integer> curr = Arrays.asList(nums[i],nums[j],third);
        //             Collections.sort(curr);
        //             st.add(curr);
        //         }
        //         else{
        //             s.add(nums[j]);
        //         }
        //     }
        // }
        // List<List<Integer>> ans = new ArrayList<>(st);
        // return ans;

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i>0 && nums[i] == nums[i-1])continue;
                int j=i+1;
                int k = n-1;
                while(j<k){
                  int sum = nums[i] + nums[j]+nums[k];
                  
                  if(sum == 0){
                    List<Integer> curr = Arrays.asList(nums[i],nums[j],nums[k]);
                    ans.add(curr);
                    j++;
                    k--;
                    while(j<k && nums[j] == nums[j-1])j++;
                    while(j<k && nums[k] == nums[k+1])k--;

                  }
                  else if(sum<0){
                    j++;
                  }
                  else{
                    k--;
                  }
                  
                }
            
        }
        return ans;
    }

    //4Sum Problem 
    public List<List<Integer>> fourSum(int[] nums, int target) {
        /* List<List<Integer>> ans = new ArrayList<>();
            int n = nums.length;
            Arrays.sort(nums);
            for(int i=0;i<n-3;i++){
                          if (i > 0 && nums[i] == nums[i - 1]) continue;
  
              for(int j=i+1;j<n-2;j++){
                //while (i>0 && nums[i] == nums[i-1])continue;
                while (j>i+1&& nums[j] == nums[j-1])continue;
                int k = j+1;
                int l = n-1;
                while (k<l) {
                  int sum = nums[i];
                  sum += nums[j];
                  sum += nums[k];
                  sum += nums[l];
                  if (sum == target) {
                    List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k],nums[k]);
                    ans.add(temp);
                    k++;
                    l--;
                    while (k<l && nums[k] == nums[k-1])k++;
                    while (k<l && nums[l] == nums[l+1])l--;
                  }
                  else if (sum<target) {
                    k++;
                  }
                  else{
                    l--;
                  }
                }
  
                  
               
              }
            }
            return ans; */
  
             List<List<Integer>> ans = new ArrayList<>();
          int n = nums.length;
          if (n < 4) return ans; 
  
          Arrays.sort(nums); 
          for (int i = 0; i < n - 3; i++) {
              if (i > 0 && nums[i] == nums[i - 1]) continue; 
  
              for (int j = i + 1; j < n - 2; j++) {
                  if (j > i + 1 && nums[j] == nums[j - 1]) continue; 
  
                  int k = j + 1;
                  int l = n - 1;
  
                  while (k < l) {
                      long sum = (long) nums[i] + nums[j] + nums[k] + nums[l]; 
  
                      if (sum == target) {
                          ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                          k++;
                          l--;
  
                          while (k < l && nums[k] == nums[k - 1]) k++;
                          while (k < l && nums[l] == nums[l + 1]) l--;
                      } else if (sum < target) {
                          k++;
                      } else {
                          l--;
                      }
                  }
              }
          }
  
          return ans;
      }

      //Count number of subarrays with given xor K
      public static int subarraysWithSumK(int []a, int b) {
        int cnt = 0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        int xor = 0;
        for(int i=0;i<a.length;i++){
           xor ^= a[i];
           int rem = xor^b;
           if(mp.containsKey(rem)){
               cnt += mp.get(rem);
           }

           if(!mp.containsKey(xor)){
               mp.put(xor,1);
           }
           else{
               mp.put(xor,mp.get(xor)+1);
           }

        }
        return cnt;
    }

    //Merge Overlapping Intervals
     public int[][] merge(int[][] intervals) {
        int n = intervals.length; 
        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int firstStart = intervals[0][0];
        int firstEnd = intervals[0][1];
        for(int interval[]:intervals){
            int currStart = interval[0];
            if(currStart<=firstEnd){
                //Merge
                firstEnd = Math.max(firstEnd, interval[1]);

             }
            else{
               merged.add(new int[]{firstStart,firstEnd});
               firstStart = currStart;
               firstEnd = interval[1];
            }
        }

        merged.add(new int[]{firstStart, firstEnd});
        return merged.toArray(new int[merged.size()][]);


    }

    //Merge two sorted arrays without extra space
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = n+m-1;
        int j = n-1;
        int i = m-1;
        while(i>=0 && j>=0){
            if(nums1[i]>=nums2[j]){
                nums1[last] = nums1[i];
                last--;
                i--;
            }
            else{
                nums1[last] = nums2[j];
                j--;
                last--;
            }
        }
        // while(i>=0){
        //      nums1[last] = nums1[i];
        //         last--;
        //         i--;
        // }
        while(j>=0){
            nums1[last] = nums2[j];
                j--;
                last--;
        }

    }

    //Find the repeating and missing number
    public static int[] findMissingRepeatingNumbers(int []a) {
        // Write your code here
        // int i=0;
        // int n = a.length;
        // while(i<n){
        //     int correct = a[i]-1;
        //    if(a[i]!= a[correct]){
        //         int temp = a[i];
        //         a[i] = a[correct];
        //         a[correct] = temp;
        //    }
        //    else {
        //        i++;
        //    }
           
        // }
        // int ans[] = new int[2];
        // for(int idx=0;idx<a.length;idx++){
        //     if(a[idx] != idx+1){
        //         ans[0] = a[idx];
        //         ans[1] = idx+1;
        //     }
        // }
        // return ans;
        
        int n = a.length;
        long S = 0;
        long S2 = 0;

        for (int num : a) {
            S += num;
            S2 += (long) num * num;
        }

        long Sn = (long) n * (n + 1) / 2;
        long Sn2 = (long) n * (n + 1) * (2 * n + 1) / 6;

        long diff = S - Sn;               // X - Y
        long sum = (S2 - Sn2) / diff;     // X + Y

        long X = (diff + sum) / 2;        // Repeating
        long Y = X - diff;                // Missing

        return new int[]{(int) X, (int) Y};

    }

    //Count Inversions 
    public static int merge(int a[], int low,int mid, int high){
        ArrayList<Integer> temp = new ArrayList<>();
        int i= low;
        int j = mid+1;
        int cnt = 0;
        while(i<=mid && j<=high){
           if(a[i]>a[j]){
               cnt += mid-i+1;
               temp.add(a[j]);
               j++;
           }
           else{
               temp.add(a[i]);
               i++;
           }
        }

        while(i<=mid){
          temp.add(a[i]);
               i++;
        }

        while(j<=high){
         temp.add(a[j]);
               j++;
        }

        for(int id = low;id<=high;id++){
            a[id] = temp.get(id-low);
        }
        return cnt;
    }
    public static int mergeSort(int a[], int low, int high){
        if(low>=high)return 0;
        int cnt =0;
        int mid = low+(high-low)/2;
        cnt += mergeSort(a,low,mid);
        cnt += mergeSort(a,mid+1,high);
        cnt += merge(a, low, mid, high);
        return cnt;
    }
    public static int numberOfInversions(int []a, int n) {
        // Write your code here.
        return mergeSort(a,0,n-1);
    }

    //Reverse Pairs
    public int countPairs(int a[], int low,int mid, int high){
        int cnt = 0;
        int right = mid+1;
        for(int i=low;i<=mid;i++){
          while(right <= high && (long) a[i] > 2L * (long) a[right]){
            right++;
        }
            cnt += right-(mid+1);
        }
        return cnt;

    }
     public  void merge2(int a[], int low,int mid, int high){
        ArrayList<Integer> temp = new ArrayList<>();
        int i= low;
        int j = mid+1;
        
        while(i<=mid && j<=high){
           if(a[i]>a[j]){
               temp.add(a[j]);
               j++;
           }
           else{
               
               temp.add(a[i]);
               i++;
           }
        }

        while(i<=mid){
          temp.add(a[i]);
               i++;
        }

        while(j<=high){
         temp.add(a[j]);
               j++;
        }

        for(int id = low;id<=high;id++){
            a[id] = temp.get(id-low);
        }
        
    }
     public  int mergeSort2(int a[], int low, int high){
        if(low>=high)return 0;
        int cnt =0;
        int mid = low+(high-low)/2;
        cnt += mergeSort2(a,low,mid);
        cnt += mergeSort2(a,mid+1,high);
        cnt += countPairs(a,low,mid,high);
        merge2(a, low, mid, high);
        return cnt;
    }
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return mergeSort2(nums,0,n-1);
    }

    //Maxium Product Subarray
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int prefix =1;
        int suffix = 1;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(prefix == 0)prefix =1;
            if(suffix == 0)suffix = 1;
            prefix *= nums[i];
            suffix *= nums[n-i-1];
            max = Math.max(max,Math.max(prefix,suffix));
        }

        return max;

    }
    public static void main(String[] args) {
        
    }
}
