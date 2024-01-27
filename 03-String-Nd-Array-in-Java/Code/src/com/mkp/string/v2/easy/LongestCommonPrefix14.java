package src.com.mkp.string.v2.easy;

public class LongestCommonPrefix14 {

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder ans=new StringBuilder();
        int minLength=Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            minLength=Math.min(minLength,strs[i].length());
        }

        for (int i = 0; i < minLength; i++) {
            char current=strs[0].charAt(i);
            for (String str:strs){
                if(str.charAt(i) != current){
                    return ans.toString();
                }
            }
            ans.append(current);
        }
        return ans.toString();
    }
}
