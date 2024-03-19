package src.com.mkp.v2.easy;

public class SetMismatch645 {
    public int[] findErrorNums(int[] nums) {
        cyclicSort(nums);
        int[] ans=new int[2];
        for(int i = 0;i < nums.length;i++){
            if(i+1 != nums[i]){
                ans[0]=nums[i];
                ans[1]=i+1;
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
