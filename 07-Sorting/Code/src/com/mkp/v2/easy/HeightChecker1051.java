package src.com.mkp.v2.easy;

public class HeightChecker1051 {

    /*
    * solution using sorting
    * */
    public int heightChecker(int[] heights) {
        int n = heights.length,i=0,count=0;
        int[] copy=new int[n];
        while(i < n)
            copy[i]=heights[i++];
        sort(heights,0,n-1);
        i=0;
        while(i < n)
            if(copy[i] != heights[i++]) count++;
        return count;
    }

    public void sort(int[] arr,int s,int e){
        if(s >= e) return;
        int pivotIndex=s+(e-s)/2,pivot=arr[pivotIndex],l=s,r=e;
        while(l <= r){
            while(arr[l] < pivot) l++;
            while(arr[r] > pivot) r--;

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
