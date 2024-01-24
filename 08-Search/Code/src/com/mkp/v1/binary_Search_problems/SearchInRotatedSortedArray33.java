package src.com.mkp.v1.binary_Search_problems;

public class SearchInRotatedSortedArray33 {

//    https://leetcode.com/problems/search-in-rotated-sorted-array/description/
//    https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/



    public static void main(String[] args) {
//        int[] arr = {4,5,6,6,7,0,1,2,4,4};
//        int[] arr = {2,5,6,0,0,1,2};
        int[] arr = {1,1,1,1,1,1,3,1};
        System.out.println(findPivotWithDuplicates(arr));
//        int[] arr = {4,5,6,7,0,1,2};
//        int[] arr = {4, 5, 6, 7, 8, 9, 0, 1, 2};
//        int[] arr = {7,0,1,2,3,4,5,6};
//        int[] arr = {0,1,2,3,4,5,6};
//        int[] arr = {11,13,15,17};
//        int[] arr = {5,6,0,0,1};
        int target = 0;
//        System.out.println(findPivot(arr));
//        System.out.println(search(arr, target));
//        System.out.println(rotationCount(arr));
//        System.out.println(findMin(arr));
    }

    private static int search(int[] arr, int target) {
//        here pivot is nothing but rotation last number
        int pivot = findPivot(arr);

        int ans = binarySearch(arr, 0, pivot, target);
        if (ans == -1) {
            ans = binarySearch(arr, pivot + 1, arr.length - 1, target);
        }

        return ans;
    }

    private static int findPivot(int[] arr) {
        int s = 0, e = arr.length - 1;
        while (s <= e) {
            int m = e + (s - e) / 2;
//            if m+1 is less than m - [4,5,6,7,0,1,2]
            if (m + 1 < e && arr[m + 1] < arr[m]) return m;
//            if m-1 is greater than m - [4,5,6,0,1,2,3]
            if (m - 1 >= 0 && arr[m - 1] > arr[m]) return m - 1;

            if (arr[m] >= arr[s]) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }

        return arr.length-1;
    }

    //    https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
    private static int findPivotWithDuplicates(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases over here
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid-1;
            }

            // if elements at middle, start, end are equal then just skip the duplicates
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                // skip the duplicates
                // NOTE: what if these elements at start and end were the pivot??
                // check if start is pivot
                if (start < end && arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                // check whether end is pivot
                if (end > start && arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            }
            // left side is sorted, so pivot should be in right
            else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return arr.length-1;
    }

    private static int binarySearch(int[] arr, int s, int e, int target) {
        while (s <= e) {
            int m = e + (s - e) / 2;
            if (target < arr[m]) e = m - 1;
            else if (target > arr[m]) s = m + 1;
            else return m;
        }
        return -1;
    }

    //    https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
    private static int rotationCount(int[] arr) {
        int s = 0, e = arr.length - 1;
        while (s <= e) {
            int m = e + (s - e) / 2;
//            if m+1 is less than m - [4,5,6,7,0,1,2]
            if (m + 1 < e && arr[m + 1] < arr[m]) return  m+1;
//            if m-1 is greater than m - [4,5,6,0,1,2,3]
            if (m - 1 >= 0 && arr[m - 1] > arr[m]) return  m;

            if (arr[m] >= arr[s]) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return 0 ;
    }

    private static int findMin(int[] arr) {
        int s=0,e=arr.length-1;
        while(s <= e){
            int m=e+(s-e)/2;
//            if m+1 is less than m - [4,5,6,7,0,1,2]
            if( m+1 < e && arr[m+1] < arr[m]) return arr[m+1];
//            if m-1 is greater than m - [4,5,6,0,1,2,3]
            if( m-1 >= 0 && arr[m-1] > arr[m]) return arr[m];

            if(arr[m] >= arr[s]){
                s=m+1;
            }else{
                e=m-1;
            }
        }

        return arr[0] ;
    }
}
