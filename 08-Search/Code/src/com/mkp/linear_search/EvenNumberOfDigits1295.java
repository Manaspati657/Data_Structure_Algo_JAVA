package src.com.mkp.linear_search;

public class EvenNumberOfDigits1295 {
    //    The time complexity of linear search O(n).
    public static void main(String[] args) {
        int[] nums = {555,901,-482,-1771};
        System.out.println(findNumbers(nums));

        System.out.println(digits2(-345678));
    }

    private static int digits2(int no) {
        if(no < 0) no*=-1;
        return (int)(Math.log10(no)) + 1;
    }

    private static int findNumbers(int[] nums) {
        if(nums.length == 0 ) return -1;
        int count=0;
        for (int e:nums) {
            if(digits(e) % 2 == 0) count++;
        }
        return count;
    }


    private static int digits(int no) {
//        if (no < 0) {
//            no = no * -1;
//        }
        int count=0;
        while(no != 0){
            no/=10;
            count++;
        }
        return count;
    }
}
