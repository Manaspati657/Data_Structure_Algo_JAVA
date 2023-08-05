package src.com.mkp.array;

public class FindMax {
    public static void main(String[] args) {
        int[] arr={232,3,53,33,77,46,96};
        System.out.println(max(arr));
    }

    private static int max(int[] arr) {
        int max=arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > max) max = arr[i];
        return max;
    }
}
