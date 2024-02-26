package src.com.mkp.v2.easy;

public class SortArrayByParity905 {
    public int[] sortArrayByParity(int[] nums) {
        int n=nums.length;
        if(n <=1) return nums;
        int[] ans=new int[n];
        int evenIndex=0,oddIndex=n-1;
        for(int el:nums){
            if(el%2 == 0){
                ans[evenIndex++]=el;
            }else{
                ans[oddIndex--]=el;
            }
        }
        return ans;
    }
}
