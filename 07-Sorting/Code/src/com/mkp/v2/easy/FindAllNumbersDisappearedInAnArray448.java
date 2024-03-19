package src.com.mkp.v2.easy;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        cyclicSort(nums);
        List<Integer> ans=new ArrayList<>();
        for(int i = 0;i < nums.length;i++){
            if(i+1 != nums[i]){
                ans.add(i+1);
            }
        }
        return ans;
    }

    public void cyclicSort(int[] nums){
        int i = 0 ;
        while(i < nums.length){
            int current = nums[i];
            if(nums[current-1] != current){
                //swap
                int temp=nums[current-1];
                nums[current-1]=nums[i];
                nums[i]=temp;
            }else{
                i++;
            }
        }
    }
}
