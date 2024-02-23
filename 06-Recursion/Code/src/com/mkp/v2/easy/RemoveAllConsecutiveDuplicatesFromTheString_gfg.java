package src.com.mkp.v2.easy;

public class RemoveAllConsecutiveDuplicatesFromTheString_gfg {
    public static void main(String[] args) {
        String s= "aaaaabbbbbb";
        System.out.println(removeDuplicateCharacter(s));
    }

    private static String removeDuplicateCharacter(String s) {
        StringBuilder ans=new StringBuilder();
        helper(s,ans,0);
        return ans.toString();
    }

    private static void helper(String s, StringBuilder ans,int i) {
        if(i >= s.length()) return;
        if(ans.length() == 0) ans.append(s.charAt(i));
        else if(s.charAt(i) != ans.charAt(ans.length()-1))
            ans.append(s.charAt(i));
        helper(s, ans, i+1);
    }
}
