package src.com.mkp.v2.easy;

public class ValidPerfectSquare367 {
    public boolean isPerfectSquare(int num) {
        if(num == 1 ) return true;
        int s=1,e=num/2;
        while(s <= e){
            long mid=s+(e-s)/2,mul=mid*mid;
            if(mul == num) return true;
            else if(mul > num) e=(int)mid-1;
            else s=(int)mid+1;
        }

        return false;
    }
}
