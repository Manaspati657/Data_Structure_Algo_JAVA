package src.com.mkp.theory;

import java.util.Arrays;

public class LSDRadixSortString {

//    It works but i can't understand

    public static void main(String[] args) {
        String[] s={"mkp","axd","xyz","abc","pqr","mno"};
        System.out.println(Arrays.toString(s));
        radixSort(s,3);
        System.out.println(Arrays.toString(s));
    }

    public static void sort(String[] a, int W)
    {
        int R = 256;
        int N = a.length;
        String[] aux = new String[N];
        for (int d = W-1; d >= 0; d--)
        {
            int[] count = new int[R+1];
            for (int i = 0; i < N; i++)
                count[a[i].charAt(d) + 1]++;
            for (int r = 0; r < R; r++)
                count[r+1] += count[r];
            /* doubt in this for loop*/
            for (int i = 0; i < N; i++)
                aux[count[a[i].charAt(d)]++] = a[i];
            for (int i = 0; i < N; i++)
                a[i] = aux[i];
            System.out.println(Arrays.toString(aux));
        }
    }

    public static void radixSort(String[] a, int W){
        int N = a.length;
        for (int i = W-1; i >= 0; i--) {
            int[] count=new int[256];
            String[] aux=new String[a.length];

            for (int j = 0; j < N; j++) {
                char lastChar=a[j].charAt(i);
                count[lastChar]++;
            }

            for (int j = 1; j < 256; j++) {
                count[j]+=count[j-1];
            }

            for (int j = N-1; j >= 0; j--) {
                char lastChar=a[j].charAt(i);
                aux[count[lastChar]-1]=a[j];
                count[lastChar]--;
            }

            for (int j = 0; j < N; j++) {
                a[j]=aux[j];
            }

        }
    }

}
