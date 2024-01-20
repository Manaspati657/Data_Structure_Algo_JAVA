package src.com.mkp.array.easy;

public class FindMax {
    public static void main(String[] args) {
        int[] arr={232,3,53,33,77,46,96};
        System.out.println(max(arr));
        System.out.println(maxInRange(arr,2,5));
    }

    private static int max(int[] arr) {
        int max=arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > max) max = arr[i];
        return max;
    }

    private static int maxInRange(int[] arr , int start,int end) {
        if(start> end) return -1;
        if(arr==null) return -1;
        int max=arr[start];
        for (int i = start; i < end; i++)
            if (arr[i] > max) max = arr[i];
        return max;
    }


}
