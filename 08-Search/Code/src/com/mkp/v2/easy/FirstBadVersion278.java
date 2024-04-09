package src.com.mkp.v2.easy;

public class FirstBadVersion278 {

    public int firstBadVersion(int n) {
        int s=1,ans=0;
        while(s<=n){
            int m=s+(n-s)/2;
            if(isBadVersion(m)){
                n=m-1;
                ans=m;
            }
            else s=m+1;
        }

        return ans;
    }

    //predefined method of leetcode.
    private boolean isBadVersion(int m) {
        return true;
    }
}
