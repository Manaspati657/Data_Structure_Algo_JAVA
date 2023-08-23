package src.com.mkp.problems;

public class ValidAnagram242 {

    public static void main(String[] args) {
//       String s = "anagram", t = "nagaram";
       String s = "rat", t = "car";
        System.out.println(isAnagram(s,t));
    }


    public static boolean isAnagram(String s, String t) {
        char[] sCh=s.toCharArray();
        char[] tCh=t.toCharArray();
        sort(sCh,0,sCh.length-1);
        sort(tCh,0,tCh.length-1);
        return new String(sCh).equals(new String(tCh));
    }

    private static void sort(char[] nums, int start, int end) {
        int s=start,e=end;
        char pivot=nums[(e+(s-e)/2)];
        if( end <= start) return;
        while(s<=e){
            while (nums[s] < pivot) s++;
            while (nums[e] > pivot) e--;
            if(s <= e){
                exch(nums,s,e);
                s++;
                e--;
            }
        }
        sort(nums,start,e);
        sort(nums,s,end);
    }
    private static void exch(char[] a , int i ,int j){
        char swap=a[i];
        a[i]=a[j];
        a[j]=swap;
    }
}
