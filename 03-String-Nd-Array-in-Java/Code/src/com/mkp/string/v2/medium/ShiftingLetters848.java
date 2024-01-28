package src.com.mkp.string.v2.medium;

public class ShiftingLetters848 {

    public static void main(String[] args) {
        String s = "abc";
        int[] shifts = {3,5,9};
        System.out.println(shiftingLetters(s,shifts));
    }


//    time limit exceed
    public static String shiftingLetters(String s, int[] shifts) {
        char[] sChar=s.toCharArray();
        for(int i = 0 ;i < shifts.length;i++){
            for(int j =0;j <= i;j++)
                sChar[j]= (char)((sChar[j] - 'a'+shifts[i]) % 26 +'a');
        }
        return new String(sChar);
    }

    public static String shiftingLettersV1(String s, int[] shifts) {
        StringBuilder res = new StringBuilder(s);
        for (int i = shifts.length - 2; i >= 0; i--)
            shifts[i] = (shifts[i] + shifts[i + 1]) % 26;
        for (int i = 0; i < s.length(); i++)
            res.setCharAt(i, (char)((s.charAt(i) - 'a' + shifts[i]) % 26 + 'a'));
        return res.toString();
    }
}
