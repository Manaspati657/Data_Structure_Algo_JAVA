package src.com.mkp.theory;

public class FindKthElement {
    public static void main(String[] args) {
        int[] arr={4,2,6,3,8,9,10,1};
        String s="manas";
        System.out.println(kthSmallElement(arr,3));
    }

//    Using Brute Force Approach : Selection sort or Bubble sort.

//    Selection sort
    private static int kthSmallElement(int[] arr,int k) {
        int smallIndex=Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            smallIndex=getMin(arr,i);
            swap(arr,i,smallIndex);
            if(i+1 == k) break;
        }
        return arr[k-1];
    }

    private static void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }


    private static int getMin(int[] arr, int s) {
        int min=s;
        for (int i = s; i < arr.length; i++) {
            if(arr[min] > arr[i]) min=i;
        }
        return min;
    }
}
