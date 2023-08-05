package src.com.mkp.string;

public class Pallindrom {

    public static void main(String[] args) {
        System.out.println(isPallindrom("manas"));
    }

    private static boolean isPallindrom(String str) {
//      m a n a m
//      0 1 2 3 4

        if(str.isEmpty()) return true;
        else{
            for (int i = 0; i <= str.length()/2; i++) {
                char start=str.charAt(i);
                char end= str.charAt( str.length() - i - 1 );
                if(start != end) return false;
            }
        }

        return true;
    }
}
