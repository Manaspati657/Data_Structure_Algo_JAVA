package src.com.mkp.Sliding_Window;

public class StringCompression443 {
    public static void main(String[] args) {
//        char[] chars = {'a','a','b','b','c','c','c'};
        char[] chars = {'a','b','c','c','c'};
        System.out.println(compress(chars));
    }
    public static int compress(char[] chars) {
        int i = 0,n=chars.length,count=0;
        char currentChar=chars[0];
        StringBuilder str=new StringBuilder();
        while(i < n){
            if(currentChar == chars[i]){
                count++;
            }else{
                str.append(currentChar);
                if(count > 1) str.append(count);
                currentChar=chars[i];
                count=1;
            }
            i++;
        }
        str.append(currentChar);
        if(count > 1)  str.append(count);
        return str.length();
    }
}
