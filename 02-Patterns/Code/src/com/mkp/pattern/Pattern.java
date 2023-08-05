package Code.src.com.mkp.pattern;

public class Pattern {
    public static void main(String[] args) {
        pattern6(5);
    }

    static void pattern6(int no){
        for (int i = 1; i <= 2 * no; i++) {
            int space = (i <= no ) ? no - i : i-no ;
//          print space
            for (int j = 1; j <= space  ; j++) {
                System.out.print(" ");
            }
            int star= (i <= no ) ? i : (2 * no) -i ;
//            System.out.println(space+" - "+i+" - "+star);
            for (int j = 1; j <= star ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }


    static void pattern5(int no){
        for (int i = 1; i <= no; i++) {
//          print space
            for (int j = 1; j <= no - i  ; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <=i ; j++) {
                System.out.print(i+" ");
            }
            System.out.println();
        }

    }
    static void pattern4(int no){
        for (int i = 1; i <= no; i++) {
//          print space
            for (int j = 1; j <= no - i  ; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2*i -1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
    static void pattern1(int no){
        for (int i = 1; i <= no; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }
    static void pattern2(int no){
        for (int i = 1; i <= no; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }

    }
    static void pattern3(int no){
        for (int i = 1; i <= no; i++) {
//          print space
            for (int j = 1; j <= no - i  ; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <=i ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }


}
