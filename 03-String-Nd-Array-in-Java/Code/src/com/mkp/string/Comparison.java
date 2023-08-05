package src.com.mkp.string;

public class Comparison {
    public static void main(String[] args) {

//        String a = "manas";
//        String b = "manas";
//        String c=a;

//        System.out.println(a==b);//true bcz two String object share same object reference from String pool
//        System.out.println(b==c); // true bcz same condition

        String name1=new String("manas");
        String name2=new String("manas");

//      false bcz == compare references but here name1 and name2 create separate obj not
//      also create one object in string pool area
        System.out.println(name1==name2);
//      true .equals compare value
        System.out.println(name1.equals(name2));




//      total two object one in heap and another in string pool
        String str=new String("java");

    }

}
