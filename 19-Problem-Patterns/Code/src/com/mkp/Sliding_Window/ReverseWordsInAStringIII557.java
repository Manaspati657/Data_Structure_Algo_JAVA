package src.com.mkp.Sliding_Window;

public class ReverseWordsInAStringIII557 {
    public static void main(String[] args) {
//        String s = "Let's take LeetCode contest";
        String s = "manasa kumar pati";
        System.out.println(reverseWords(s));
    }
    public static String reverseWords(String s) {
        char[] charArr=s.toCharArray();
        int start=0;
        for (int i = 0; i < charArr.length; i++) {
            if(charArr[i] == ' ' || i == charArr.length-1){
                reverse(charArr,start,i == charArr.length-1 ? i : i-1);
                start=i+1;
            }
        }
        return new String(charArr);
    }

    public static void reverse(char[] arr,int i , int j){
        while( i < j){
            char temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
}
