package src.com.mkp.v2.easy;

public class TwoSumIIInputArrayIsSorted167 {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for(int i = 0;i < n;i++){
            int s=i+1,e=n-1;
            while(s <= e){
                int mid=s+(e-s)/2,sum=numbers[i]+numbers[mid];
                if(sum == target){
                    return new int[]{i+1,mid+1};
                }else if(sum < target){
                    s=mid+1;
                }else{
                    e=mid-1;
                }
            }
        }
        return new int[]{-1,-1};
    }
}
