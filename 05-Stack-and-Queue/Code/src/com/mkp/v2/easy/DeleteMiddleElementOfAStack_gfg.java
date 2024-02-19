package src.com.mkp.v2.easy;
import  java.util.Stack;
public class DeleteMiddleElementOfAStack_gfg {
    /*
    * using temp stack
    * */
    public void deleteMidv1(Stack<Integer>s,int sizeOfStack){
        // code here
        int mid= sizeOfStack/2;
        Stack<Integer> stack=new Stack<>();
        while(mid != 0){
            stack.push(s.pop());
            mid--;
        }
        s.pop();
        while(!stack.isEmpty())
            s.push(stack.pop());
    }


    /*
    *
    * using recursion
    * */

    public void deleteMid(Stack<Integer>s,int sizeOfStack){
        // code here
        // check when we hit the middle pop one element and return;
        if(s.size() == (sizeOfStack+1)/2){
            s.pop();
            return ;
        }
        //store the current value in temp
        int temp=s.pop();
        deleteMid(s,sizeOfStack);
        //while return push it to the stack
        s.push(temp);
    }
}
