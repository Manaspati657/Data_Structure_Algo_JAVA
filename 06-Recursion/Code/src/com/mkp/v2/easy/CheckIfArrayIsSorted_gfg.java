package src.com.mkp.v2.easy;

public class CheckIfArrayIsSorted_gfg {

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
//        int[] arr={1,8,2,3,4,5};
        System.out.println(arraySortedOrNot(arr,arr.length));
    }

    static boolean arraySortedOrNot(int[] arr, int n) {
        // code here
        if(n <= 1) return true;
        return arr[n - 2] <= arr[n - 1] && arraySortedOrNot(arr, n - 1);
    }
}
