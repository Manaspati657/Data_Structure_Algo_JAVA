package src.com.mkp.string.v2.easy;

import java.util.HashMap;
import java.util.Map;

public class RobotReturnToOrigin657 {
    public static void main(String[] args) {
        // String s = "UD";
        // String s = "RD";
        // String s = "LL";
         String s = "UULLDDRRURLDURLD";
        System.out.println(judgeCircle(s));
    }

    public static boolean judgeCircle(String moves) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('U', 0);
        map.put('D', 0);
        map.put('L', 0);
        map.put('R', 0);

        for (int i = 0; i < moves.length(); i++)
            map.put(moves.charAt(i), map.get(moves.charAt(i)) + 1);

        return (map.get('U').equals(map.get('D'))) && (map.get('R').equals(map.get('L')));
    }
    //  time takes 9 sec
    public boolean judgeCircleV2(String moves) {
        int x=0,y=0;
        for(int i = 0;i<moves.length();i++){
            if(moves.charAt(i) == 'L') x++;
            else if(moves.charAt(i) == 'R') x--;
            else if(moves.charAt(i) == 'U') y++;
            else if(moves.charAt(i) == 'D') y--;
        }

        return x == 0 && y == 0;
    }
    //   run time is first may be for toCharArray. Time takes 4 sec
    public boolean judgeCircleV3(String moves) {
        int x = 0, y = 0;
        for (char move: moves.toCharArray()) {
            if (move == 'U') y--;
            else if (move == 'D') y++;
            else if (move == 'L') x--;
            else if (move == 'R') x++;
        }
        return x == 0 && y == 0;
    }
}
