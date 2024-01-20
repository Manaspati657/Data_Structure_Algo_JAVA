package src.com.mkp.string.v1;

public class AtoZSeries {
    public static void main(String[] args) {
        StringBuffer smallLetter=new StringBuffer();
        StringBuffer capitalLetter=new StringBuffer();
        char a = 'a';
        char A = 'A';
        for (int i = 0; i < 26; i++) {
            char sm= (char) (a+i);
            char cap= (char) (A+i);
            smallLetter.append(sm);
            capitalLetter.append(cap);
        }
        System.out.println(smallLetter);
        System.out.println(capitalLetter);
    }
}
