package DP;

import java.util.Arrays;

public class FrogJump {

    public static int solve(int idx , int arr[], int t[]){
        if (idx == 0) {
            return 0;
        }
        if (t[idx] != -1) {
            return t[idx];
        }
        int left = solve(idx-1, arr, t)+Math.abs(arr[idx]-arr[idx-1]);
        int right = Integer.MAX_VALUE;
        if(idx>1) right = solve(idx-2, arr, t)+Math.abs(arr[idx]-arr[idx-2]);
        return Math.min(left, right);
    }

    public static int frogJump(int n, int arr[]){
        int t[] = new int[n];
        t[0] = 0;
        t[1] = Math.abs(arr[0]-arr[1]);
        for(int i=2;i<n;i++){
            int first = t[i-1] +Math.abs(arr[i]-arr[i-1]);
            int second = t[i-2] +Math.abs(arr[i]-arr[i-2]);   
            t[i] = Math.min(second, first);
        }
        return t[n-1];
    }
    public static void main(String[] args) {
        int arr [] = new int[5];
        int n = arr.length;
        int t[] = new int[n];
        Arrays.fill(t, -1);
        System.out.println(solve(n-1, arr, t));
    }
}
