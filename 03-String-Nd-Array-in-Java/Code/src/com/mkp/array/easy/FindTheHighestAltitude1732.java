package src.com.mkp.array.easy;

public class FindTheHighestAltitude1732 {
    public static void main(String[] args) {
        int[] gain = {-5,1,5,0,-7};
        System.out.println(largestAltitude(gain));
    }

    public static int largestAltitude(int[] gain) {
        int ans=Integer.MIN_VALUE,n=gain.length;
        int altitude=gain[0];
        for(int i = 1 ;i < n;i++ ){
            System.out.println(altitude);
            altitude+=gain[i];
            ans=Math.max(ans,altitude);
        }
        return ans;
    }
}
