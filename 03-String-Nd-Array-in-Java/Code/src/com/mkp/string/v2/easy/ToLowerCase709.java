package src.com.mkp.string.v2.easy;

public class ToLowerCase709 {
    public static void main(String[] args) {
        String s = "Manas";
        System.out.println(toLowerCaseV2(s));
    }

    public static String toLowerCase(String s) {
        char[] array = new char[s.length()];

        int index = 0;
        for (char ch : s.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                array[index++] = (char) ((ch - 'A') + 'a');
            } else {
                array[index++] = ch;
            }
        }
        return new String(array);
    }

    /*
    *
    *   as ASCII value of 'A' = 65 and 'a' = 97 so difference is 32 so if we add 32 any upper case then we
    *   will get lowercase character.
    *
    * */
    public static String toLowerCaseV2(String s) {
        char[] array = new char[s.length()];

        int index = 0;
        for (char ch : s.toCharArray()) {
            if (ch > 64 && ch < 91) {
                array[index++] = (char) ((ch + 32));
            } else {
                array[index++] = ch;
            }
        }
        return new String(array);
    }

    public static String toLowerCaseV1(String s) {
        char[] arr=s.toCharArray();
        for(int i =0 ;i < arr.length;i++)
            arr[i]=Character.toLowerCase(arr[i]);
        return new String(arr);
    }
}
