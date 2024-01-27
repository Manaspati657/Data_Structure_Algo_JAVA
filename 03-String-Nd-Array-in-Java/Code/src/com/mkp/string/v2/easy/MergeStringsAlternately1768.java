package src.com.mkp.string.v2.easy;

public class MergeStringsAlternately1768 {
    public static void main(String[] args) {
        String word1 = "abc", word2 = "pqrs";
        System.out.println(mergeAlternately(word1,word2));
    }


    //  With char array
    public static String mergeAlternately(String word1, String word2) {
        int m = word1.length(),n=word2.length(),i=0,j=0,min=Math.min(m,n),index=0;
        char[] ans=new char[m+n];
        while(min > 0){
            if(i < m) ans[index++]=word1.charAt(i++);
            if(j < n) ans[index++]=word2.charAt(j++);
            min--;
        }

        while(i < m) ans[index++]=word1.charAt(i++);
        while(j < n) ans[index++]=word2.charAt(j++);

        return new String(ans);
    }

//    With StringBuilder class
    public String mergeAlternatelyV1(String word1, String word2) {
        int m = word1.length(),n=word2.length(),i=0,j=0,index=0;
        if(m == 0 || n == 0) return (m == 0) ? word2 : word1;
        StringBuilder ans=new StringBuilder();
        while(i < m || j < n ){
            if(i < m) ans.append(word1.charAt(i++));
            if(j < n) ans.append(word2.charAt(j++));
        }

        return ans.toString();
    }
}
