package src.com.mkp.linear_search;

import java.util.Arrays;

public class SearchInStrings {
    //    The time complexity of linear search O(n).
    public static void main(String[] args) {
        String name = "Manas";
        char target = 's';
        System.out.println(search(name, target));
        System.out.println(search2(name, target));

//        System.out.println(Arrays.toString(name.toCharArray()));
    }

    private static boolean search2(String name, char target) {
        if(name.isEmpty()) return false;

        for (char ch:name.toCharArray()) {
            if(ch == target) return true;
        }

        return false;
    }

    private static boolean search(String name, char target) {
        if(name.isEmpty()) return false;

        for (int i = 0; i < name.length() ; i++) {
            if(target == name.charAt(i)) return true;
        }

        return false;
    }
}
