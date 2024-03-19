package src.com.mkp.v2.easy;

public class AverageSalaryExcludingTheMinimumAndMaximumSalary1491 {

    public double average(int[] salary) {
        int n = salary.length;
        sort(salary,0,n-1);
        double total=0;
        for(int i = 1 ;i < n-1;i++)
            total+=salary[i];
        return total/(n-2);
    }

    public void sort(int[] arr,int s, int e){
        if(s >= e) return ;
        int pI=s+(e-s)/2,p=arr[pI],l=s,r=e;
        while(l<=r){
            while(arr[l] < p) l++;
            while(arr[r] > p) r--;

            if(l<=r){
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
