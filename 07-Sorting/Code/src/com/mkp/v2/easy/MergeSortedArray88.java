package src.com.mkp.v2.easy;

public class MergeSortedArray88 {


//    without using any extra space.

    public void mergeV2(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;
        if(m == 0){
            int l= 0;
            while(l < n)
                nums1[l]=nums2[l++];
            return;
        }
        //without using any extra space
        m = m-1;
        n = n-1;
        int i = nums1.length -1;
        while(n >= 0){
            if(m >= 0 && nums1[m] > nums2[n]){
                nums1[i--]=nums1[m--];
            }else{
                nums1[i--]=nums2[n--];
            }
        }
    }


    // using extra space.
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;
        if(m == 0){
            int l= 0;
            while(l < n)
                nums1[l]=nums2[l++];
        }
        // using extra space.
        int[] ans=new int[m+n];
        int i = 0,j = 0 , k = 0;
        while(i < m && j < n){
            if(nums1[i] < nums2[j]){
                ans[k++]=nums1[i++];
            }else{
                ans[k++]=nums2[j++];
            }
        }
        while(i < m)
            ans[k++]=nums1[i++];
        while(j < n)
            ans[k++]=nums2[j++];


        i=0;
        while(i < ans.length)
            nums1[i]=ans[i++];
    }
}
