package src.com.mkp.string.v2.easy;

public class GoalParserInterpretation1678 {
    public static void main(String[] args) {
        String command = "G()(al)";
        System.out.println(interpret(command));
    }

    public static String interpret(String command) {
        int i =0,n=command.length();
        StringBuilder ans=new StringBuilder();
        while(i < n){
            if(command.charAt(i) == 'G'){
                ans.append("G");
                i++;
            }
            else if(command.charAt(i) == '(' && command.charAt(i+1) == ')'){
                ans.append('o');
                i+=2;
            }else{
                ans.append("al");
                i+=4;
            }
        }
        return ans.toString();
    }
}
