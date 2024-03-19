package src.com.mkp.v2.easy;

public class CanMakeArithmeticProgressionFromSequence1502 {

    public boolean canMakeArithmeticProgression(int[] arr) {
        int n = arr.length;
        sort(arr,0,n-1);
        int diff=arr[1]-arr[0];

        for(int i = n-1 ; i > 0 ;i--){
            if(arr[i] - arr[i-1] != diff) return false;
        }

        return true;
    }

    public void sort(int[] arr,int s , int e){
        if(s >= e) return ;
        int pI=s+(e-s)/2,p=arr[pI],l=s,r=e;
        while(l <= r){
            while(arr[l] < p) l++;
            while(arr[r] > p) r--;

            if(l <= r){
                //swap
                int temp=arr[l];
                arr[l]=arr[r];
                arr[r]=temp;

                l++;
                r--;
            }
        }

        sort(arr,s,r);
        sort(arr,l,e);
    }
}
