package src.com.mkp.v2.medium;

import java.util.Stack;

public class AsteroidCollision735 {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();
        for(final int el:asteroids){
            // if we find any positive asteroid size then we just add it to the stack
            if(el > 0 ){
                stack.push(el);
            }//else we found a negative asteroid size .
            else{
                // destroy / remove the top element if peek element is less than the current asteroids
                // first we check the peek element is positive or not then  only we compare the current element to that.
                // while compare, we convert the negative element to positive by -el
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -el)
                    stack.pop();
                // we check if stack is empty or peek element also negative then we just push the element to the stack.
                if(stack.isEmpty() || stack.peek() < 0)
                    stack.push(el);
                // another check if same size asteroid basically if there is same size asteroid in peek stack then we destroy /
                // remove the element.
                if(stack.peek() == -el)
                    stack.pop();
            }
        }

        int[] ans=new int[stack.size()];
        int i = stack.size()-1;
        while(!stack.isEmpty()){
            ans[i]=stack.pop();
            i--;
        }
        return ans;
    }
}
