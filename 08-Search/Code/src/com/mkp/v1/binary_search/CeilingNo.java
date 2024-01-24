package src.com.mkp.v1.binary_search;

public class CeilingNo {
    //    The time complexity of binary search O(log n).
//    Given a sorted array and a value x, the ceiling of x is the smallest element
//    in an array greater than or equal to x
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int target = 5;
//        System.out.println(arr[ceiling(arr, target)]);
        System.out.println(ceiling(arr, target));
    }

    private static int ceiling(int[] arr, int target) {
        int s=0,e=arr.length-1;
        if(target > arr[e]) return -1;
        while( s <= e){
            int mid=e+(s-e)/2;
            if(arr[mid] > target) e= mid-1;
            else if(arr[mid] < target) s= mid+1;
            else return mid;
        }

        return s;
    }


}
