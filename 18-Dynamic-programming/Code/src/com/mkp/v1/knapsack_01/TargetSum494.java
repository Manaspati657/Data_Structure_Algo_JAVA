package src.com.mkp.v1.knapsack_01;

import java.util.HashMap;
import java.util.Map;

public class TargetSum494 {

    public static Map<String,Integer> dp=new HashMap<>();

    public static void main(String[] args) {
        int arr[] = {5, 2, 6, 4}, diff=3;
//        int arr[] = {1, 2, 3, 1, 2}, diff=1;
//        int arr[] = {1, 5, 3, 4, 2}, diff=3;
//        int arr[] = {0,0,0,0,0,0,0,0,1}, diff= 1;
        System.out.println(findTargetSumWays(arr,arr.length,diff));
    }

    private static int findTargetSumWays(int[] arr, int length, int diff) {
        return helper(arr,diff,0,0);
    }

    private static int helper(int[] arr, int diff, int index, int sum) {

        if(index == arr.length && sum == diff) return 1;
        if(index == arr.length && sum != diff) return 0;

        String key=sum+"()"+index;
        if(dp.containsKey(key)){
            return dp.get(key);
        }

        int count = 0;
        //first case we take negative value of current index
        count += helper(arr, diff, index + 1, sum - arr[index]);
        //second case we take positive value of current index
        count += helper(arr, diff , index + 1, sum + arr[index]);

        //add to map for future use.
        dp.put(key, count);

        return count;

    }
}
