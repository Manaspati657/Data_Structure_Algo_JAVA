package src.com.mkp.string.v2.easy;

public class NumberOfStringsThatAppearAsSubStringsInWord1967 {
    public static void main(String[] args) {
        String[] patterns = {"a","abc","bc","d"};
        String word = "abc";
        System.out.println(numOfStrings(patterns,word));
    }
    public static int numOfStrings(String[] patterns, String word) {
        int count=0;
        for(String pat:patterns){
            if(word.contains(pat)) count++;
        }
        return count;
    }
}
