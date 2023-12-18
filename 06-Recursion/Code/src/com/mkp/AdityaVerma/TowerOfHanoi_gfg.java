package src.com.mkp.AdityaVerma;

public class TowerOfHanoi_gfg {

    /*
    *
    * problem statement: bhai youtube dekhle 😁
    *
    * take 2 discs example : first move disc 1 "from" to "aux" and use "to" as an "aux" rod.
    * then move disc 1 "aux" to "to" and use "from" as an "aux" rod.
    *
    * */

    private static long count=0;
    public static void main(String[] args) {
        System.out.println(toh(3,1,3,2));
    }

    public static long toh(int N, int from, int to, int aux) {
        // Your code here
        helper(N,from,to,aux);
        return count;
    }

    private static void helper(int N, int from, int to, int aux) {
        if(N == 1){
            count++;
            System.out.println("move disk "+N+" from rod "+from+" to rod "+to);
            return;
        }
        helper(N-1,from,aux,to);
        count++;
        System.out.println("move disk "+N+" from rod "+from+" to rod "+to);
        helper(N-1,aux,to,from);
    }


}
