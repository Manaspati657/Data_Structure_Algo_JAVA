package src.com.mkp.v2.easy;

public class NumberOfStepsToReduceANumberToZero1342 {

//    using loop
    public int numberOfStepsV1(int num) {
        int i = 0;
        while(num != 0){
            if(num % 2 == 0) num /=2;
            else num--;
            i++;
        }
        return i;
    }

//    using recursion

    public int numberOfSteps(int num) {
        return helper(num,0);
    }

    private int helper(int num,int i){
        if(num == 0) return i;

        if(num % 2 == 0) return helper(num/2,i+1);

        return helper(num-1,i+1);
    }
}
