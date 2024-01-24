package src.com.mkp.v1.linear_search;

public class SearchInRange {
    //    The time complexity of linear search O(n).
    public static void main(String[] args) {
        int[] arr = {18, 12, -7, 3, 14, 28};
        int target = 3;
        System.out.println(linearSearch(arr, target, 1, 75));
    }

    private static int linearSearch(int[] arr, int target, int s, int e) {
        if(arr.length ==0 ) return -1;
        int start = s >= 0 && s < arr.length ? s : 0 ,
                end=e >= 0 && e < arr.length ? e : arr.length;
        for (int i = start; i < end; i++) {
            if(arr[i]==target) return i;
        }
        return -1;
    }

}
