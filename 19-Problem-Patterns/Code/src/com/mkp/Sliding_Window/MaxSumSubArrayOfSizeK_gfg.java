package src.com.mkp.Sliding_Window;

public class MaxSumSubArrayOfSizeK_gfg {
    public static void main(String[] args) {
        int k = 2;
        int[] arr = {100, 200, 300, 400};
        System.out.println(maximumSumSubArrayV2(arr,k));
    }

//    sliding window technique : time complexity- O(N)
    private static long maximumSumSubArrayV2(int[] arr, int k) {
        long ans=0,sum=0;
        int i = 0 , j = 0, n=arr.length;

//        Note : windows size is formula is j-i+1 gives the window size k .
        while( j < n){
            int windowSize=j-i+1;
            // ? calculation on every move ::
            // sum every new element.
            sum+=arr[j];
            // until we reach the window size we increment the j variable
            if(windowSize < k) j++;
            // ? Slide window
            // if we hit the window size then get the result first and then slide the window
            else if(windowSize == k){
                // Get the result from the window
                ans = (sum > ans) ? sum : ans;
                // remove the windows first  element calculation
                sum -= arr[i];

                // slide the window
                i++;
                j++;
            }
        }
        return ans;
    }

    //    Brute force approach : Time complexity : O( N * k) , time limit exceed.
    public static long maximumSumSubArray(int[] nums, int k) {
        long ans = 0;

        for (int i = 0; i <= nums.length-k; i++) {
            long sum = 0;
            for (int j = 0; j < k; j++) {
                sum += nums[i+j];
            }
            ans = (sum > ans) ? sum : ans;
        }

        return ans;
    }
}
