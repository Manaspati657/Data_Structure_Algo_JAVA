package src.com.mkp.problems;

import java.util.HashMap;

public class NonRepeatingElement_gfg{


    public static void main(String[] args) {
        int arr[] = {-1, 2, -1, 3, 2};
        System.out.println(firstNonRepeating(arr,arr.length));
    }
    // brute force approch but time exceeded.
    // Time complextiy is : O(N^2)
     public static int firstNonRepeating1(int arr[], int n)
     {
       for(int i = 0;i < n ;i++){
           boolean flag=true;
           for(int j =0 ;j < n ;j++)
               if(i != j && arr[i] == arr[j])
                  flag=false;
           if(flag) return arr[i];
       }
       return 0;
     }

    // using hashmap we can store the count and iterate through
    //  the map check the count if 1 then return
    // Time Complexity: for building hashmap : O(N)
    //                  for checking the count : O(N)
    // O(N+N) = O(N)
    public static int firstNonRepeating(int arr[], int n)
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i = 0;i < n ;i++){
            if(map.containsKey(arr[i])){
                Integer x=map.get(arr[i]);
                map.put(arr[i],x+1);
            }else{
                map.put(arr[i],1);
            }
        }
        for(int i = 0; i < n ;i++){
            if(map.get(arr[i]) == 1){
                return arr[i];
            }
        }
        return 0;
    }
}
