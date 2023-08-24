package src.com.mkp.binary_Search_problems;

public class InfiniteSortedArraySearch {
//https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
    public static void main(String[] args)
    {
        int arr[] = new int[]{3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170};
        int ans = findPos(arr,10);

        if (ans==-1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at index " + ans);
    }

    private static int findPos(int[] arr, int target) {

        int s =0, e=1;
        while(true){
            if(target < arr[e])break;
            int temp=e+1;// this is my new start
            // double the box value
            // end = previous end + sizeof-box*2
            e=e+(e-s+1)*2;
            s=temp;
        }

//        System.out.println(e+"-"+s);

        return searchInsert(arr,s,e,target);
    }

    public static int searchInsert(int[] nums,int s ,int e, int target) {
        while( s <= e){
            int mid=e+(s-e)/2;
            if(nums[mid] > target) e= mid-1;
            else if(nums[mid] < target) s= mid+1;
            else return mid;
        }

        return -1;
    }
}
