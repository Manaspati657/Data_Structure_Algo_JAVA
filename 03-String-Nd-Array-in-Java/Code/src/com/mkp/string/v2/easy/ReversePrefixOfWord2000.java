package src.com.mkp.string.v2.easy;

public class ReversePrefixOfWord2000 {
    public static void main(String[] args) {
        String word = "abcdefd";
        char ch = 'd';
        System.out.println(reversePrefix(word,ch));
    }
    public static String reversePrefix(String word, char ch) {
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == ch){
                return reverseWord(word,0,i);
            }
        }
        return word;
    }

    public static String reverseWord(String s,int sI,int eI){
        char[] charArr=s.toCharArray();
        while (sI <= eI){
            char temp=charArr[sI];
            charArr[sI]=charArr[eI];
            charArr[eI]=temp;
            sI++;
            eI--;
        }
        return new String(charArr);
    }
}
