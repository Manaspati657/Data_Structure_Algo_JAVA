package src.com.mkp.string.v2.easy;

public class LongPressedName925 {
    public static void main(String[] args) {

//        String name = "alex", typed = "aaleex";
//        String name = "saeed", typed = "ssaaedd";
//        String name = "rick", typed = "kric";
        String name = "vtkgn", typed = "vttkgnn";
        System.out.println(isLongPressedName(name,typed));
    }

    public static boolean isLongPressedName(String name, String typed) {
        int m = name.length(),n=typed.length(),i=0,j=0;
        if(m > n) return false;
        if(name.charAt(0) != typed.charAt(0) ||
                name.charAt(m-1) != typed.charAt(n-1)) return false;
        while( j < n){
            if(i < m && name.charAt(i) == typed.charAt(j)){
                i++;
            }else if(j == 0 || typed.charAt(j) != typed.charAt(j-1)) return false;
            j++;
        }
        return i == m;
    }
}
