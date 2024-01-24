package src.com.mkp.v1.theory_stack;

public class Main_Stack {
    public static void main(String[] args) {

//        Stack using LinkedList and its time complexity and space complexity
        /*
        * Time Complexity: O(1), for all push(), pop(), and peek(),
        * as we are not performing any kind of traversal over the list.
        * We perform all the operations through the current pointer only.
        * Auxiliary Space: O(N), where N is the size of the stack
        *
        * */
        /*Stack_LinkedList<Integer> list =new Stack_LinkedList<>();
        list.push(2);
        list.push(4);
        list.push(8);
        list.push(3);
        System.out.println("peek: "+list.peek());
        System.out.println(list);
        System.out.println("pop: "+list.pop());
        list.push(6);
        list.push(1);
        System.out.println("peek: "+list.peek());
        System.out.println(list);
        System.out.println("size : "+list.size());*/


        //        Stack using LinkedList and its time complexity and space complexity
        /*
         * Time Complexity: O(1), for all push(), pop(), and peek(),
         * as we are not performing any kind of traversal over the list.
         * We perform all the operations through the current pointer only.
         * Auxiliary Space: O(N), where N is the size of the Array
         *
         * */

        Stack_Array<Integer> list =new Stack_Array<>();
        list.push(2);
        list.push(4);
        list.push(8);
        list.push(3);
        list.push(6);
        list.push(9);
        list.push(1);
        list.push(7);
        System.out.println(list);
        System.out.println("peek: "+list.peek());
        System.out.println("pop: "+list.pop());
        System.out.println("pop: "+list.pop());
        System.out.println("pop: "+list.pop());
        System.out.println("pop: "+list.pop());
        System.out.println("pop: "+list.pop());
        System.out.println(list);
        System.out.println("pop: "+list.pop());
        list.push(6);
        list.push(1);
        System.out.println("peek: "+list.peek());
        System.out.println(list);
        System.out.println("size : "+list.size());

    }
}
