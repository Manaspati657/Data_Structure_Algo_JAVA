package src.com.mkp.binary_search;

public class OrderAgnosticBS {
    // Not mentioned the array is sorted in ascending or descending
    public static void main(String[] args) {
//        int[] arr = {-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89};
        int[] arr = {99, 80, 75,66, 22, 11, 10, 5, 2, -3};
        int target = 22;
        int ans = search(arr, target);
        System.out.println(ans);
    }

    private static int search(int[] arr, int target) {
        if(arr.length == 0 ) return -1;
        int lo=0,hi=arr.length-1;
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
}
