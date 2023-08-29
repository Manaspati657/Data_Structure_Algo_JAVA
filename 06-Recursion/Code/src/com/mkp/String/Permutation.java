package src.com.mkp.String;

public class Permutation {
    public static void main(String[] args) {
        permutations("", "abc");

//        ArrayList<String> ans = permutationsList("", "abc");
//        System.out.println(ans);

//        System.out.println(permutationsCount("", "abcd"));
    }

    private static void permutations(String ip, String op) {
        if(op.isEmpty()){
            System.out.println(ip);
            return;
        }
        char ch=op.charAt(0);
        for (int i = 0; i <= ip.length(); i++) {
            String f=ip.substring(0,i);
            String s=ip.substring(i,ip.length());
            permutations(f+ch+s,op.substring(1));
        }
    }
}
