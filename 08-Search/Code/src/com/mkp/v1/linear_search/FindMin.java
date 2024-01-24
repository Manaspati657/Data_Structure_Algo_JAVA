package src.com.mkp.v1.linear_search;

public class FindMin {
//    The time complexity of linear search O(n).
    public static void main(String[] args) {
        int[] arr = {18, 12, 7, 3, 14, 28};
        System.out.println(min(arr));
    }

    private static int min(int[] arr) {
        if(arr.length ==0 ) return Integer.MIN_VALUE;
        int min=arr[0];
        for (int e: arr) {
          if(e < min) min=e;
        }
        return min;
    }
}
