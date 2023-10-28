package src.com.mkp.theory;

import java.util.Arrays;

public class KeyIndexSorting {

    public static void main(String[] args) {
        int[] arr={4,3,1,2,7,8,0,4,2,3,2};
        System.out.println(Arrays.toString(arr));
        countingSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void countingSort(int[] arr) {
        int N=arr.length;
        int R=getMax(arr)+1;
        int[] count=new int[R];
        int[] aux= new int[N];

        for (int i = 0; i < N; i++) {
            count[arr[i]]++;
        }

        for (int i = 1; i < R; i++) {
            count[i]+=count[i-1];
        }
//        System.out.println(Arrays.toString(count));
//        run reverse for stable ans
        for (int i = N-1; i >= 0; i--) {
            aux[count[arr[i]]-1]=arr[i];
            count[arr[i]]--;
        }
        for (int i = 0; i < N; i++) {
            arr[i]=aux[i];
        }
    }


    private static void countingSort2(int[] a){
        int N = a.length;
        int R=getMax(a)+1;
        int[] aux= new int[N];
        int[] count = new int[R+1];
        for (int i = 0; i < N; i++)
            count[a[i]+1]++;
        for (int r = 0; r < R; r++)
            count[r+1] += count[r];
        for (int i = 0; i < N; i++)
            aux[count[a[i]]++] = a[i];
        for (int i = 0; i < N; i++)
            a[i] = aux[i];
    }
    private static int getMax(int[] arr){
        int max=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(max < arr[i]) max=arr[i];
        }
        return max;
    }


}
