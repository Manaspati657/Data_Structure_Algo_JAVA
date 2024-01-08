package src.com.mkp.Sliding_Window;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets904 {
    public static void main(String[] args) {
        int[] fruits={1,2,3,2,2};
//        int[] fruits={0};
//        int[] fruits={1,1};
        System.out.println(totalFruit(fruits));
    }
    public static int totalFruit(int[] fruits) {
        int ans=0,i=0,j=0,n=fruits.length;
        if(fruits.length == 1) return 1;
        Map<Integer,Integer> map=new HashMap<>();

        while(j<n){
            map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);
            
            if(map.size() <= 2) {
                ans=Math.max(ans,j-i+1);
                j++;
            }else if(map.size() > 2){
                while(map.size() > 2){
                    map.put(fruits[i],map.get(fruits[i])-1);
                    if(map.get(fruits[i]) == 0) map.remove(fruits[i]);
                    i++;
                }
                j++;
            }
        }
        return ans;
    }
}
