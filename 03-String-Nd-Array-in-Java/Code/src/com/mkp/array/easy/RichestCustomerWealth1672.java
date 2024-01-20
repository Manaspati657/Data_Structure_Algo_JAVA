package src.com.mkp.array.easy;

public class RichestCustomerWealth1672 {
    public static void main(String[] args) {
        int[][] accounts = {{1,2,3},{3,2,1}};
        System.out.println(maximumWealth(accounts));
    }

    public static int maximumWealth(int[][] accounts) {
        int n =accounts.length,max=0;
        if(n == 0) return max;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum+=accounts[i][j];
            }
            max= Math.max(max,sum);
        }
        return max;
    }
}
