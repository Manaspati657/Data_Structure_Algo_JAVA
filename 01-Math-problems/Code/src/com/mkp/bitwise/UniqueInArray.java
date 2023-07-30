package src.com.mkp.bitwise;

public class UniqueInArray {
    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 4, 2, 6, 4};
        System.out.println(getUnique(arr));
    }

    public static int getUnique(int[] arr){
        int unique = 0;
        for (int i = 0; i < arr.length; i++) {
            unique ^= arr[i];
        }

        return  unique;

    }
}
