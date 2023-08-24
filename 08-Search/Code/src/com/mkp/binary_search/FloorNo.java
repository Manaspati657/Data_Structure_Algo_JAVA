package src.com.mkp.binary_search;

public class FloorNo {
    //    The time complexity of binary search O(log n).
//    Given a sorted array and a value x,the floor is the greatest element smaller
//    than or equal to x
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 12, 15, 19};
        int target = 14;
//        System.out.println(arr[ceiling(arr, target)]);
        System.out.println(floor(arr, target));
    }

    private static int floor(int[] arr, int target) {
        int s=0,e=arr.length-1;
        if(target > arr[e]) return e;
        while( s <= e){
            int mid=e+(s-e)/2;
            if(arr[mid] > target) e= mid-1;
            else if(arr[mid] < target) s= mid+1;
            else return mid;
        }

        return e;
    }
}
