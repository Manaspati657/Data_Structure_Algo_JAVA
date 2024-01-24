package src.com.mkp.v1.easyProblems;

public class CountZeroes {

    public static void main(String[] args) {
        System.out.println(countZeroes(103400));
    }

    private static int countZeroes(int no) {
        return helper(no,0);
    }

    private static int helper(int no, int count) {
        if(no == 0) return count;
        else if(no % 10 ==0 ){
            return helper(no/10,++count);
        }
        return helper(no/10,count);
    }
}
