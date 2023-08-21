package src.com.mkp.pattern;

public class Pattern_recursion {
    public static void main(String[] args) {
//        printStar5To1(5,0);
        printStar1To5(5,0);
    }

    private static void printStar5To1(int row, int col) {
        if(row < 0 ) return;
        if(row-1 < col){
            System.out.println();
            printStar5To1(--row,0);
        }else{
            System.out.print("* ");
            printStar5To1(row ,++col );
        }
    }
    private static void printStar1To5(int row, int col) {
        if(row < 0 ) return;
        if(row-1 < col){
            printStar1To5(--row,0);
            System.out.println();
        }else{
            printStar1To5(row ,++col );
            System.out.print("* ");
        }
    }

}
