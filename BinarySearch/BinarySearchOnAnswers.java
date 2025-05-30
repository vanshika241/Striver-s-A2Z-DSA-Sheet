
public class BSAnswers {

    //Find square root of a number in log n
    public static int sqrtN(long N) {
		if(N == 0)return 0;
		 long start = 1;
		 long end = N;
		 long ans = -1;
		 while(start <=end){
			 long mid = start +(end-start)/2;
			
            if((long)mid * mid <= N){
				ans = mid;
				start = mid+1;
			}
			else{
                end = mid-1;
			}
		 }
		 return (int)ans;
	}

    //Find the Nth root of a number using binary search
    public int findValue(int n , int mid){
        int i=1;
        int ans = 1;
        while(i<=n){
            ans = ans*mid;
            i++;
        }
        return ans;
    }
    public int nthRoot(int n, int m) {
        // code here
        if(m == 0)return 0;
        int start = 1;
        int end = m;
        while(start <=end){
           int mid = start +(end-start)/2;
            int getAns = findValue(n,mid);
            if(getAns == m){
                return mid;
            }
            else if(getAns > m){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return -1;
    }

    //koko Eating Bananas
    public int getTotalHours(int piles[], int midHour){
        int totalHours = 0;
        for(int i=0;i<piles.length;i++){
            totalHours += (int)Math.ceil((double)piles[i]/midHour);
        }
        return totalHours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = 0;
        for(int i=0;i<piles.length;i++){
            end = Math.max(end , piles[i]);
        }
        int minHours =end  ;

        while(start <=end){
            int mid = start +(end-start)/2;
            int getHours = getTotalHours(piles,mid);
            if(getHours <= h){
                minHours = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return minHours;
    }

    //
    public static void main(String[] args) {
        
    }
}
