package src.com.mkp.binary_Search_problems;

public class FindInMountainArray1095 {

    public static void main(String[] args) {
        int[] arr={1,5,2};
        int target =2;
//        int[] arr={1,2,3,4,5,3,1};
//        int[] arr={0,1,2,4,2,1};
//        int target =3;
        System.out.println(findInMountainArray(target,arr));
    }
    public static int findInMountainArray(int target, int[] arr) {
        int peak=findPeakElement(arr);
        int ans=search(arr,0,peak,target);
        if(ans == -1) ans = search(arr,peak+1,arr.length-1,target);
        return ans;
    }

    private static int search(int[] arr,int lo,int hi, int target) {
        if(arr.length == 0 ) return -1;
        boolean isAsc= arr[lo] < arr[hi];
        while (lo <= hi){
            int mid=lo+(hi-lo)/2;
            if(target < arr[mid]) {
                if ((isAsc)) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else if(target > arr[mid]) {
                if (isAsc) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else return mid;
        }
        return -1;
    }


    public static int findPeakElement(int[] arr) {
        int s = 0,e=arr.length-1;
        while (s < e){
            int m = s +(e-s)/2;
            if( m+1 < arr.length && arr[m] > arr[m+1]){
                e=m;
            }else{
                s=m+1;
            }
        }
        return s;
    }
}
