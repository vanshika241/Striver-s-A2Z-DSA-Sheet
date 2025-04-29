package DP;

import java.util.Arrays;

public class HouseRobber1 {

    //Recursion 
    public static int funcMax(int arr[], int idx){
        if (idx ==0) {
            return arr[0];
        }
        if(idx<0)return 0;
        int pick = arr[idx]+funcMax(arr, idx-2);
        int nonpick = 0+funcMax(arr, idx-1);
        return Math.max(pick, nonpick);
    }

    //Memoization
    public static int funcMaxMemo(int arr[], int idx, int t[]){
        if (idx ==0) {
            return arr[0];
        }
        if(idx<0)return 0;
        if (t[idx] != -1) {
            return t[idx];
        }
       
        int pick = arr[idx]+funcMaxMemo(arr, idx-2,t);
        int nonpick = 0+funcMaxMemo(arr, idx-1,t);
        return  t[idx] = Math.max(pick, nonpick);
        
    }

    //Tabulation
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

    //Space Optimization
    public static int funcMemoOpt(int arr[]){
        int prev = arr[0];
        int prev2 = 0;
        for(int i=1;i<arr.length;i++){
            int pick = arr[i];
            if(i>1)pick += prev2;
            int nonpick = prev;
            int curr = Math.max(pick, nonpick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
    public static void main(String[] args) {
         int[] arr = {2, 7, 9, 3, 1};

    System.out.println("Recursive: " + funcMax(arr, arr.length - 1));

    int[] t = new int[arr.length];
    Arrays.fill(t, -1);
    System.out.println("Memoization: " + funcMaxMemo(arr, arr.length - 1, t));

    System.out.println("Tabulation: " + funcMaxtabu(arr));
    System.out.println("Space Optimized: " + funcMemoOpt(arr));
    }
}
