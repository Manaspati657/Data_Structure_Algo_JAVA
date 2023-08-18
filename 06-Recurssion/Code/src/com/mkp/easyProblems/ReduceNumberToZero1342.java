package src.com.mkp.easyProblems;

public class ReduceNumberToZero1342 {

    public static void main(String[] args) {
        System.out.println(numberOfSteps(123));
    }

    public static  int numberOfSteps(int num) {
        return helper(num,0);
    }

    static int helper(int no,int count){
        if(no==0) return count;
        if(no % 2 == 0){
            return helper(no/2,++count);
        }
        return helper(--no,++count);
    }
}
