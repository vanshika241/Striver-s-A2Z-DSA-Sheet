class Solution {
     public static int funcMaxtabu(int arr[]){
        int n = arr.length;
        int t[] = new int[n];
        t[0] = arr[0];
        for(int i=1;i<n;i++){
            int pick = arr[i];
            if(i>1)pick += t[i-2];
            int nonpick  = t[i-1];
            t[i] = Math.max(pick, nonpick);
        }
        return t[n-1];
    }
    public int rob(int[] nums) {
         int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        int[] nums1 = new int[n - 1];
        int[] nums2 = new int[n - 1];

        for(int i = 0; i < n - 1; i++) {
            nums1[i] = nums[i];
        }
        for(int i = 1; i < n; i++) {
            nums2[i - 1] = nums[i];
        }
        int ans1 = funcMaxtabu(nums1);
        int ans2 = funcMaxtabu(nums2);
        return Math.max(ans1,ans2);
    }
}
