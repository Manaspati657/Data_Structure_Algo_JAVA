package src.com.mkp.problems;

public class ContainsDuplicate217 {

    public static void main(String[] args) {
        int[] nums={1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(nums));
    }
    public static boolean containsDuplicate(int[] nums) {
        sort(nums,0,nums.length-1);
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == nums[i+1]) return true;
        }
        return false;
    }

    private static void sort(int[] nums, int start, int end) {
        int s=start,e=end;
        int pivot=nums[(e+(s-e)/2)];
        if( end <= start) return;
        while(s<=e){
            while (nums[s] < pivot) s++;
            while (nums[e] > pivot) e--;
            if(s <= e){
                exch(nums,s,e);
                s++;
                e--;
            }
        }
        sort(nums,start,e);
        sort(nums,s,end);
    }
    private static void exch(int[] a , int i ,int j){
        int swap=a[i];
        a[i]=a[j];
        a[j]=swap;
    }

}
