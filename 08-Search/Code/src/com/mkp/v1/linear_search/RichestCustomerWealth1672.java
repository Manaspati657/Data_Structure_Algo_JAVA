package src.com.mkp.v1.linear_search;

public class RichestCustomerWealth1672 {
    //    The time complexity of linear search O(n).
    public static void main(String[] args) {
//        int[][] arr={{1,2,3},{3,2,1}};
        int[][] arr={{1,5},{7,3},{3,5}};
        System.out.println(maximumWealth(arr));
    }

    public static int maximumWealth(int[][] accounts) {
        if(accounts.length == 0) return -1;
        int max = 0;
        for (int[] arr:accounts) {
            int sum=0;
            for (int e:arr) {
                sum+=e;
            }
            if(sum > max) max=sum;
        }
        return max;
    }
}
