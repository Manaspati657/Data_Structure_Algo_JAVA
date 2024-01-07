package src.com.mkp.Sliding_Window;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class MaximumOfAllSubArraysOfSizeK_gfg {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
//        int k = 3;
        int[] arr = {9,10,9,-7,-4,-8,2,-6};
        int k = 5;
        System.out.println(max_of_subArrays(arr,arr.length,k));
    }
    public static ArrayList<Integer> max_of_subArrays(int arr[], int n, int k)
    {
        // Your code here
        ArrayList<Integer> ans=new ArrayList<>();
        int i=0,j=0;
        Deque<Integer> queue=new ArrayDeque<>();
        while(j < n){
            int windowSize=j-i+1;
            // ? calculation on every move ::
            // add the element to the queue but before add it check if any element less than that
            // number is present in the queue if exist then remove it .
            while(!queue.isEmpty() && queue.peekLast() < arr[j])
                queue.removeLast();
            queue.addLast(arr[j]);

            // until we reach the window size we increment the j variable
            if(windowSize < k) j++;

            // ? Slide window
            //if we hit the window size then get the result first and then slide the window
            else if(windowSize == k){
                // Get the result from the window

                ans.add(queue.peek());
                // remove the windows first  element calculation
                if(!queue.isEmpty() && queue.peek() == arr[i]) queue.removeFirst();

                // slide the window
                i++;
                j++;
            }
        }
        return ans;
    }
}
