package src.com.mkp.AdityaVerma;

public class PrintAllSubSequence {

    /*
    *
    * Problem statement:
    *   print all sub-sequence : take two method parameter op (output) and ip (input) .
    *   in every recursion call we have two choices: in both condition ip will be decrease to small value.
    *     i) we take the current character with our op.
    *     ii) we don't take the character with our op.
    *   At one time ip will be empty, and we get the op as the answer.
    *
    *   This Solution work if every character are unique if any one character is repeat then same output will be
    *   print. ( use one Set to store all op for duplicate issue ).
    *
    * */

    public static void main(String[] args) {
//        printAllSubSequence("abc");
        printAllSubSequence("aab");
    }

    private static void printAllSubSequence(String str) {
        helper("",str);
    }

    private static void helper(String op, String ip) {
        if(ip.isEmpty()) {
            System.out.print(op+" - ");
            return;
        }
        helper(op+ip.charAt(0),ip.substring(1));
        helper(op,ip.substring(1));
    }
}
