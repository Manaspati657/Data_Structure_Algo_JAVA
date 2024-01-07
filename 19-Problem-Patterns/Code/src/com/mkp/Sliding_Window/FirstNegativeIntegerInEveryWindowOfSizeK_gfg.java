package src.com.mkp.Sliding_Window;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeIntegerInEveryWindowOfSizeK_gfg {
    public static void main(String[] args) {
        int n = 5,k =3;
        long[] arr = {-8, 2, 3, -6, 10};

        System.out.println(Arrays.toString(printFirstNegativeInteger(arr, n, k)));
    }
    public static long[] printFirstNegativeInteger(long arr[], int N, int K)
    {
        long[] ans=new long[N-K+1];
        int i =0 ,j =0;
//        queue used for storing the negative elements.
        Queue<Long> queue=new LinkedList<>();

        while(j < N){
            int windowSize=j-i+1;
            // ? calculation on every move ::
            // if the element is negative then add in it on the queue.
            if(arr[j] < 0) queue.add(arr[j]);

            // until we reach the window size we increment the j variable
            if(windowSize < K) j++;
            // ? Slide window
            // if we hit the window size then get the first negative number from the queue
            // and then slide the window
            else if(windowSize == K){
                // Get the result from the window
                if(queue.isEmpty()){
                    ans[i]=0;
                }else{
                    ans[i]=queue.peek();
                }
                // remove the windows first  element calculation
                if((arr[i] < 0 && !queue.isEmpty()) && arr[i] == queue.peek())
                    queue.remove();
                // slide the window
                i++;
                j++;
            }
        }
        return  ans;
    }
}
