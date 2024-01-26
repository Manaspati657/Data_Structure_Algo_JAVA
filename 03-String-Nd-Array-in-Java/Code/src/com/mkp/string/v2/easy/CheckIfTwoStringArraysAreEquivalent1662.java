package src.com.mkp.string.v2.easy;

public class CheckIfTwoStringArraysAreEquivalent1662 {
    public static void main(String[] args) {
        String[] word1={"ab", "c"}, word2 = {"a", "bc"};
        System.out.println(arrayStringsAreEqual(word1,word2));
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return(String.join("", word1).equals(String.join("", word2)));
    }

    public static boolean arrayStringsAreEqualV1(String[] word1, String[] word2) {
        StringBuilder s1=new StringBuilder();
        StringBuilder s2=new StringBuilder();
        for(int i = 0 ;i < word1.length;i++)
            s1.append(word1[i]);
        for(int i = 0 ;i < word2.length;i++)
            s2.append(word2[i]);

        return (s1.toString()).equals(s2.toString());
    }
}
