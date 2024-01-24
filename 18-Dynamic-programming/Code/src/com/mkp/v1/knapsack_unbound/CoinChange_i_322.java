package src.com.mkp.v1.knapsack_unbound;

import java.util.HashMap;

public class CoinChange_i_322 {
    public static void main(String[] args) {
//        int coins[] = {1,2,5}, amount = 11;
//        int coins[] = {1,7,5}, amount = 18;
//        int coins[] = {2}, amount = 3;
        int coins[] = {430,360,440,204,206,194,150,443}, amount = 3580;
        System.out.println(coinChange(coins,amount));
    }

    public static int coinChange(int[] coins, int amount) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans = helper(coins,amount,map);
        if(ans== Integer.MAX_VALUE) return -1;
//        System.out.println(map);
        return ans;
    }

    public static int helper(int[] coins,int amount,HashMap<Integer,Integer> map){
        if(amount==0) return 0;
        if(map.containsKey(amount)){
            return map.get(amount);
        }
        int ans=Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int diff=amount - coins[i];
            if(diff>=0){
                System.out.println(amount+"-"+coins[i]);
                int subAns=helper(coins,diff,map);
                if( subAns != Integer.MAX_VALUE &&  subAns+1 < ans) ans=subAns+1;
            }
        }
        map.put(amount,ans);
        return ans;
    }
}
