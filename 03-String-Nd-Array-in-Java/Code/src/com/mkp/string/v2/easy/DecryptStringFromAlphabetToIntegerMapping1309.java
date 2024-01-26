package src.com.mkp.string.v2.easy;

public class DecryptStringFromAlphabetToIntegerMapping1309 {
    public static void main(String[] args) {
        // String s = "10#11#12";
        String s = "1326#";
        System.out.println(freqAlphabets(s));
    }

    public static String freqAlphabets(String s) {
        StringBuilder str=new StringBuilder();
        int i = 0,n=s.length();
        while(i < n ){
            if(i+2 < n && s.charAt(i+2) == '#'){
                String number=s.substring(i, i+2);
                str.append((char)(97 - 1 + new Integer(number)));
                i+=3;
            } else{
                str.append((char)(97 - 1 + new Integer(s.charAt(i)+"")));
                i++;
            }
        }
        return str.toString();
    }
}
