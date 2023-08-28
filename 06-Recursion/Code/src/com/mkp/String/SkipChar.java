package src.com.mkp.String;

public class SkipChar {
    public static void main(String[] args) {
//        String s="baccad";
//        skipA("",s);
//        System.out.println(skipAandReturn("",s));
//                String s="bcapplecd";
//        skipApple("",s);
        String s="bappcapplecd";
        skipAppNotApple("",s);
    }

    private static void skipAppNotApple(String ip, String op) {
        if(op.isEmpty()) {
            System.out.println(ip);
            return;
        }
        char ch=op.charAt(0);
        if(!op.startsWith("apple") && op.startsWith("app")){
            skipAppNotApple(ip,op.substring(3));
        }else {
            skipAppNotApple(ip+ch,op.substring(1));
        }
    }

    private static void skipApple(String ip, String op) {
        if(op.isEmpty()) {
            System.out.println(ip);
            return;
        }
        char ch=op.charAt(0);
        if(op.startsWith("apple")){
            skipApple(ip,op.substring(5));
        }else {
            skipApple(ip+ch,op.substring(1));
        }
    }

    private static void skipA(String ip, String op) {
        if(op.isEmpty()) {
            System.out.println(ip);
            return;
        }
        char ch=op.charAt(0);
        if( ch == 'a'){
            skipA(ip,op.substring(1));
        }else {
            skipA(ip+ch,op.substring(1));
        }
    }
    private static String skipAandReturn(String ip, String op) {
        if(op.isEmpty())  return ip;
        char ch=op.charAt(0);
        if( ch == 'a'){
            return skipAandReturn(ip,op.substring(1));
        }
        return skipAandReturn(ip+ch,op.substring(1));

    }
}
