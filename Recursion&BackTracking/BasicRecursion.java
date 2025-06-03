
import java.util.ArrayList;
import java.util.List;


public class StriverBasic {

    //Understand recursion by print something N times
    public static void print(int n, List<String> ans ){
        if(n == 0)return;
        ans.add("Coding Ninjas");
        print(n-1,ans);
    }
    public static List<String> printNtimes(int n){
        List<String>  ans = new ArrayList<>();
        print(n,ans);
        return ans;
    }

    //Print name N times using recursion
    void printGfg(int N) {
        // code here
        if(N == 0)return;
        System.out.print("GFG" +" ");
        printGfg(N-1);
    }

    //Print 1 to N using recursion
    public static void print1toN(int n , ArrayList<Integer> ans ){
        if( n==0)return;
        print1toN(n-1,ans);
        ans.add(n);

    }
    public static int[] printNos(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        print1toN(n,ans);
        
        int arr[] = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            arr[i] = ans.get(i);
        }
        return arr;
    }

    //Print N to 1 using recursion
    void printNto1(int n) {
        if( n==0)return;
        System.out.print(n +" ");
        printNto1(n-1);
        
    }

    //Sum of first N numbers
    public static int sum(int n){
        if( n== 0)return 0;
       return n+sum(n-1);
    }
    public static int seriesSum(int n) {
        // code here
        int res = sum(n);
        
        return res;
    }

    //Factorial of N numbers
    static int factorial(int n) {
        // code here
        if(n == 1)return 1;
        return n*factorial(n-1);
    }

    //Fibonacci Number
    public int nthFibonacci(int n) {
        // code here
        if( n==0)return 0;
        if( n==1)return 1;
        return nthFibonacci(n-1)+nthFibonacci(n-2);
    }

    //Reverse the Array using Recursion 
    public static void rev(int arr[], int idx){
        if(idx == arr.length/2)return;
        rev(arr,idx+1);
        int temp = arr[idx];
        arr[idx] = arr[arr.length-idx-1];
        arr[arr.length-idx-1] = temp;
    }
    public void reverseArray(int arr[]) {
        // code here
        rev(arr,0);
    }

    //	Check if a string is palindrome or not
    public boolean pal(String s , int idx){
        if( idx >= s.length()/2)return true ;
        if(s.charAt(idx) != s.charAt(s.length()-idx-1)){
            return false;
        }
       return pal(s,idx+1);
    }
    public boolean isPalindrome(String s) {
                s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return pal(s,0);
    }

    public static void main(String[] args) {
        
    }
}
