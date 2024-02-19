package src.com.mkp.v2.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI496 {

    /*
    *
    * Without using stack approach :
    *
    * */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        for(int i = 0 ; i < nums1.length ; i++){
            for(int j = 0 ; j < nums2.length ; j++){
                if(nums1[i] == nums2[j]){
                    if(j == nums2.length-1){
                        nums1[i]=-1;
                    }
                    else {
                        int max=getMax(nums2,j);
                        nums1[i] = (nums2[j] < max) ? max : -1;
                    }
                    break;
                }
            }
        }
        return nums1;
    }

    public int getMax(int[] arr,int start){
        int max = arr[start++];
        while(start < arr.length){
            if(max < arr[start]){
                max = arr[start];
                break;
            }
            start++;
        }
        return max;
    }


   /*
   *  using stack approach : more understandable but taking extra space as stack.
   * */

    public int[] nextGreaterElementV2(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map=new HashMap<>();
        Stack<Integer> stack=new Stack<>();
        for(int el:nums2){
            // before input that in stack we check if prev values inside stack is less than the curr
            // number then all those number greater is curr number
            while(!stack.isEmpty() && stack.peek() < el)
                map.put(stack.pop(),el);
            stack.push(el);
        }

        for(int i = 0;i<nums1.length;i++){
            nums1[i]=map.getOrDefault(nums1[i],-1);
        }
        return nums1;
    }
}
