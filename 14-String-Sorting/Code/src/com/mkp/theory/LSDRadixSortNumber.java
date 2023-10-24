package src.com.mkp.theory;

import java.util.Arrays;

public class LSDRadixSortNumber {
    public static void main(String[] args) {
        int[] arr={434,334,133,233,743,268,30,64,32,3,2};
//        int[] arr={30,64,32,3,2};
        System.out.println(Arrays.toString(arr));
        radixSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void radixSort(int[] arr) {
        int digit=getHigestDigit(arr);
        int N=arr.length;
        for (int i = 0,j=1; i < digit; i++,j=j*10) {
            int[] count=new int[10];
            int[] aux=new int[N];
//            count all last digit count like counting sort
            for (int k = 0; k < N; k++) {
                count[((arr[k]/j)%10)]++;
            }
            for (int k = 1; k < count.length; k++) {
                count[k]+=count[k-1];
            }
            for (int k = N-1 ; k >= 0; k--) {
                int lastDigit=(arr[k]/j)%10;
                aux[count[lastDigit]-1]=arr[k];
                count[lastDigit]--;
            }

            for (int k = 0; k < N; k++) {
                arr[k]=aux[k];
            }
        }
    }

    private static int getHigestDigit(int[] arr) {
        int d=0;
        int max=arr[0];
        for (int i = 1; i < arr.length; i++) {
            max=Math.max(max,arr[i]);
        }
        while(max != 0){
            max=max/10;
            d++;
        }
        return d;
    }
}
