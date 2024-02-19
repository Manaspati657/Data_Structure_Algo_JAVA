package src.com.mkp.v2.medium;
import java.util.Stack;
public class Pattern132_456 {

   /*
   *  optimize: using stack: time comlexity : O(N)
   * */

    public boolean find132pattern(int[] nums) {
        Stack<Integer> s=new Stack<>();
        int k = Integer.MIN_VALUE;

        for(int i = nums.length-1;i >=0 ; i--){
            if(nums[i] < k ) return true;
            while(!s.isEmpty() && s.peek() < nums[i])
                k = s.pop();
            s.push(nums[i]);
        }

        return false;
    }

   /*
   *
   *  Brute force : Time complexity : O(N ^ 3) : TLE
   * */

    public boolean find132patternV1(int[] nums) {
        boolean has132Pattern=false;
        int n=nums.length;
        for(int i = 0 ; i < n-2 ; i++){
            for(int j = i+1;j < n-1 ; j++){
                for(int k = j+1 ; k < n ; k++){
                    if((nums[i] < nums[j] && nums[i] < nums[k]) && nums[k] < nums[j])
                        has132Pattern=true;
                }
            }
        }
        return has132Pattern;
    }

}
