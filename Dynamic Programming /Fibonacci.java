public class Fibonacci {

    //Recursive method

    public static int fibo1(int n){
        if(n == 0 || n == 1)return n;
        int ans  = fibo1(n-1)+fibo1(n-2);
        return ans;
    }

    //Memoization method
    public static int fibo2(int n, int t[]){
        if(n == 0 || n == 1)return n;
        if (t[n] != -1) {
            return t[n];
        }
        else{
            return t[n] = fibo2(n-1,t) + fibo2(n-2, t);
        }
    }
    

    //Tabulation Method
    public static int fibo3(int n){
      int t[] = new int[n+1];
      t[0] = 0;
      t[1] = 1;
      for(int i=2;i<n+1;i++){
        t[i] = t[i-1]+t[i-2];
      }
      return t[n];
    }
    
    //Space Optimization 
    public static int fibp4(int n){
        int prev1 = 1;
        int prev2 = 0;
        for(int i=2;i<n+1;i++){
            int curr = prev1+prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static void main(String[] args) {
        int n = 5;
        int t[] = new int[n+1];
        for(int i=0;i<n+1;i++){
            t[i] = -1;
        }
        System.out.println(fibo1(n));
        System.out.println(fibo2(n, t));
        System.out.println(fibo3(n));
        System.out.println(fibp4(n));
    }
}
