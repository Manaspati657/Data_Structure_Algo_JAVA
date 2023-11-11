package src.com.mkp.problems;

import java.util.HashMap;
import java.util.Map;

public class KeyPairSumInArray_gfg {

    public static void main(String[] args) {
//        int N = 6, X = 16,Arr[] = {1, 4, 45, 6, 10, 8};
//        int N = 5, X = 4,Arr[] = {1, 2, 5, 6, 7};
//        int N = 5, X = 4,Arr[] = {1, 2, 5, 6, 7};
        int N = 5, X = 10,Arr[] = {1, 2, 4, 3, 6};
        System.out.println(hasArrayTwoCandidates(Arr,N,X));
    }

    public static boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        // code here
        // create a map with  and add all element with their count
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i =0;i<n;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }

        System.out.println(map);
        for(Map.Entry<Integer,Integer> element: map.entrySet()){
            int key=element.getKey(),value=element.getValue(),diff=x-key;
            System.out.println(key+" - "+value+" - "+diff+" - "+(Math.abs(diff) == key)+" - "+(map.containsKey(Math.abs(diff))));
//            if(key > x) continue;
            if(Math.abs(diff) == key){
                if(value > 1) return true;
            }
            else if(map.containsKey(Math.abs(diff))){
                    return true;
            }
        }

        // brute force approach
//        for(int i = 0;i<n;i++){
//            for(int j = i+1; j < n; j++){
//                if(arr[i] >= x) break;
//                if(arr[i]+arr[j] == x) return true;
//            }
//        }

        return false;
    }
}
