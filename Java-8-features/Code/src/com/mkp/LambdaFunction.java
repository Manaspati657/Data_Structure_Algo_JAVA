package src.com.mkp;

@FunctionalInterface
interface LambdaInterface{
    int operation(int a,int b);

}
public class LambdaFunction{

    public static void main(String[] args) {

        LambdaInterface sumPrint= (a,b) -> a+b;
        LambdaInterface mulPrint= (a,b) -> a*b;
        LambdaInterface divPrint= (a,b) -> a/b;
        System.out.println(sumPrint.operation(2,4));
        System.out.println(mulPrint.operation(2,4));
        System.out.println(divPrint.operation(4,2));

    }

}
